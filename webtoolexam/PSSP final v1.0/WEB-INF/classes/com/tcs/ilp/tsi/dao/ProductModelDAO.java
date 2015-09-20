package com.tcs.ilp.tsi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.tcs.ilp.tsi.util.QueryConstants;
import com.tcs.ilp.tsi.vo.*;

import com.tcs.ilp.tsi.connection.ConnectionFactory;

public class ProductModelDAO {
	
	Connection con = null;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt1 = null;
	PreparedStatement pstmt2 = null;
	PreparedStatement pstmt3 = null;
	ResultSet rs = null;
	int count=0;
	ProductModelVO pVO;
	ArrayList<ProductModelVO> alPVO=new ArrayList<ProductModelVO>();
	ArrayList<RetailerVO> alRVO=new ArrayList<RetailerVO>();
	RetailerVO RVO=new RetailerVO();
	public ProductModelDAO()
	{	}
	private Connection getConnection() throws SQLException
	{
		 Connection conn;
		 conn=ConnectionFactory.getInstance().getConnection();
		 return conn;
	}
	public int add(ProductModelVO product)
	{
		int count1=0,count2=0;
		try
		{	
			con = getConnection();
			pstmt2 = con.prepareStatement(QueryConstants.SEQUENCE);
			rs=pstmt2.executeQuery();
			int nextSequence=0;
			if(rs.next())
			{
				nextSequence=rs.getInt(1);
				//System.out.println("Next sequence:"+nextSequence);
			}
			pstmt = con.prepareStatement(QueryConstants.ADDPRODUCTMODEL);
			pstmt.setInt(1, nextSequence);
			pstmt.setString(2, product.getProductModelName());
			pstmt.setString(3, product.getProductModelDescription());
			pstmt.setString(4, product.getProductModelFeatures());
			pstmt.setFloat(5, product.getProductModelPrice());
			pstmt.setInt(6, product.getProductModelThreshold());
			count = pstmt.executeUpdate();
			if(product.getRetailerID()!=0)
			{
			 //DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
				DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
				java.util.Date currentDate=new java.util.Date();
				dateFormat.format(currentDate);
				java.sql.Date cDate=new java.sql.Date(currentDate.getTime());
				//System.out.println(cDate);
				pstmt1 = con.prepareStatement(QueryConstants.TAGRETAILER);
				pstmt1.setInt(1, product.getRetailerID());
				pstmt1.setInt(2, nextSequence);
				//System.out.println("ID:"+product.getProductModelId());
				pstmt1.setDate(3, cDate);
				count1 = pstmt1.executeUpdate();
			}
			
			pstmt2=con.prepareStatement(QueryConstants.ADDQUANTITY);
			pstmt2.setInt(1, nextSequence);
			pstmt2.setInt(2,0);
			count2=pstmt2.executeUpdate();
		}
		catch( SQLException e)
		{
			 e.printStackTrace();
		}
		finally
		   {
		    try
		    {
		    	 if(rs != null)
		    		 rs.close();
		    	 if(pstmt != null)
		    		 pstmt.close();
		    	 if(con != null)
		    		 con.close();
		    }
		    catch(SQLException e)
		    {
		    	e.printStackTrace();
		    }
		   }
		if(count!=0 && count2!=0)
		{
			return count;
		}
		else
		{
			return 0;
		}
	}
	//This method is to retrieve the available retailers id
	public ArrayList<RetailerVO> viewRetailerId()
	{
		try{
			Connection con=getConnection();
			PreparedStatement stmt=con.prepareStatement(QueryConstants.VIEWRETAILERID);
			rs=stmt.executeQuery();
			while(rs.next())
			{
				RVO=new RetailerVO();
				RVO.setRetailerID(rs.getInt("retailer_id"));
				alRVO.add(RVO);
			}
		}
			catch(SQLException e)
		{
			e.printStackTrace();
		}
		return alRVO;
	}
	//This method is to retrieve the available product model id
	public List<ProductModelVO> viewProductModelID()
	{
		List<ProductModelVO> lister = new ArrayList<ProductModelVO>();
		ProductModelVO prodMod ;
		ResultSet rs=null;
		try{
		
		con=getConnection();
		pstmt=con.prepareStatement(QueryConstants.FINDPRODUCTID);
		rs=pstmt.executeQuery();
		while(rs.next())
		{
			prodMod= new ProductModelVO();
			prodMod.setProductModelId(rs.getInt("productModel_Id"));
			lister.add(prodMod);
		}}
	
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return lister;
	}
	//This method is to delete the selected product model
	public int delete(int id)
	{
		int count=0,count1=0,count2=0;
		try
		{
			con = getConnection();
			PreparedStatement ps=con.prepareStatement(QueryConstants.DELETESELECT);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(!rs.next())
			{
				PreparedStatement ps1=con.prepareStatement(QueryConstants.SELECTSTATUS);
				ps1.setInt(1, id);
				rs=ps1.executeQuery();
				if(rs.next())
				{
					//System.out.println("rs:"+rs.getString("PRODUCT_STATUS"));
					String status=rs.getString("PRODUCT_STATUS");
					if(!status.equalsIgnoreCase("Allocated"))
					{
						PreparedStatement ps2=con.prepareStatement(QueryConstants.SELECTQUANTITY);
						ps2.setInt(1, id);
						rs=ps2.executeQuery();	
						if(rs.next())
						{
							if(rs.getInt("quantity")==0)
							{
								pstmt1=con.prepareStatement(QueryConstants.DELETESTOCK);
								pstmt1.setInt(1,id);
								pstmt2=con.prepareStatement(QueryConstants.DELETEINVENTORY);
								pstmt2.setInt(1,id);
								pstmt=con.prepareStatement(QueryConstants.DELETEPRODUCTMODEL);
								pstmt.setInt(1,id);
								count1=pstmt1.executeUpdate();
								count2=pstmt2.executeUpdate();
								count=pstmt.executeUpdate();
							}
						}
					}
				}
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		if(count!=0 && count1!=0 && count2!=0)
		{
			return count;
		}
		else
		{
			return 0;
		}
	}
	//This method is to update the details of select product model id
	public int update(ProductModelVO prodMod)
	{
		int count=0;
		try
		{
			con = getConnection();
			pstmt = con.prepareStatement(QueryConstants.UPDATEPRODUCTMODEL);
			pstmt.setString(1, prodMod.getProductModelName());
			pstmt.setString(2, prodMod.getProductModelDescription());
			pstmt.setString(3, prodMod.getProductModelFeatures());
			pstmt.setFloat(4, prodMod.getProductModelPrice());
			pstmt.setInt(5, prodMod.getProductModelThreshold());
			pstmt.setInt(6, prodMod.getProductModelId());
			count=pstmt.executeUpdate();
		    if(prodMod.getRetailerID()!=0)
		    {
		    	pstmt = con.prepareStatement(QueryConstants.UPDATERTL);
		    	pstmt.setInt(1, prodMod.getRetailerID());
		    	pstmt.setInt(2,prodMod.getProductModelId());
		    	DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
				java.util.Date currentDate=new java.util.Date();
				dateFormat.format(currentDate);
				java.sql.Date cDate=new java.sql.Date(currentDate.getTime());
				pstmt.setDate(3,cDate);
				count=pstmt.executeUpdate();
		    }
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
		    {
		    	 if(rs != null)
		    		 rs.close();
		    	 if(pstmt != null)
		    		 pstmt.close();
		    	 if(con != null)
		    		 con.close();
		    }
		    catch(SQLException e)
		    {
		    	e.printStackTrace();
		    }
		}
		return count;
	}
	//This method is to retrieve the available product models
	public List<ProductModelVO> viewAll()
	{
		List<ProductModelVO> pModelsList = new ArrayList<ProductModelVO>();
		ProductModelVO productModelVObj = null;
		try
		{
			con = getConnection();
			pstmt = con.prepareStatement(QueryConstants.VIEWPRODUCTMODEL);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				productModelVObj = new ProductModelVO();
				productModelVObj.setProductModelId(rs.getInt("PRODUCTMODEL_ID"));
				productModelVObj.setProductModelName(rs.getString("PRODUCTMODEL_NAME"));
				productModelVObj.setProductModelDescription(rs.getString("PRODUCTMODEL_DESCRIPTION"));
				productModelVObj.setProductModelFeatures(rs.getString("PRODUCTMODEL_FEATURES"));
				productModelVObj.setProductModelPrice(rs.getFloat("PRODUCTMODEL_PRICE"));
				productModelVObj.setProductModelThreshold(rs.getInt("PRODUCTMODEL_THRESHOLD"));
				productModelVObj.setRetailerID(rs.getInt("RETAILER_ID"));
				productModelVObj.setTaggedDate(rs.getDate("TAGGED_DATE"));
				productModelVObj.setQuantity(rs.getInt("QUANTITY"));
				pModelsList.add(productModelVObj);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
		    {
		    	 if(rs != null)
		    		 rs.close();
		    	 if(pstmt != null)
		    		 pstmt.close();
		    	 if(con != null)
		    		 con.close();
		    }
		    catch(SQLException e)
		    {
		    	e.printStackTrace();
		    }
		}
		return pModelsList;
	}
	public ProductModelVO findProduct(ProductModelVO vo)
	{
		ProductModelVO vo1 = null;
		try
		{
			con=getConnection();
			pstmt = con.prepareStatement(QueryConstants.FINDPRODUCTINFO);
			pstmt.setInt(1, vo.getProductModelId());
			rs=pstmt.executeQuery();
		
			if(rs.next())
			{
				vo1 = new ProductModelVO();
				vo1.setProductModelId(rs.getInt(1));
				vo1.setProductModelName(rs.getString(2));
				vo1.setProductModelDescription(rs.getString(3));
				vo1.setProductModelFeatures(rs.getString(4));
				vo1.setProductModelPrice(rs.getFloat(5));
				vo1.setProductModelThreshold(rs.getInt(6));	
				pstmt1 = con.prepareStatement(QueryConstants.FINDRETAILERID);
				pstmt1.setInt(1, vo.getProductModelId());
				rs=pstmt1.executeQuery();
				if(rs.next())
				{
					vo1.setRetailerID(rs.getInt("RETAILER_ID"));
				}
			}	
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
		    {
		    	 if(rs != null)
		    		 rs.close();
		    	 if(pstmt != null)
		    		 pstmt.close();
		    	 if(con != null)
		    		 con.close();
		    }
		    catch(SQLException e)
		    {
		    	e.printStackTrace();
		    }
		}
		return vo1;
	}
	//This method is used to sort the product model table based on productmodel ID by ascending order
	public ArrayList<ProductModelVO> sortByIdAsc()
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		try
		{
		con=getConnection();
		pstmt=con.prepareStatement(QueryConstants.SORTBYIDASCP);
		rs=pstmt.executeQuery();
			while(rs.next())
			{
				pVO = new ProductModelVO();
				pVO.setProductModelId(rs.getInt("PRODUCTMODEL_ID"));
				pVO.setProductModelName(rs.getString("PRODUCTMODEL_NAME"));
				pVO.setProductModelDescription(rs.getString("PRODUCTMODEL_DESCRIPTION"));
				pVO.setProductModelFeatures(rs.getString("PRODUCTMODEL_FEATURES"));
				pVO.setProductModelPrice(rs.getFloat("PRODUCTMODEL_PRICE"));
				pVO.setProductModelThreshold(rs.getInt("PRODUCTMODEL_THRESHOLD"));
				pVO.setRetailerID(rs.getInt("RETAILER_ID"));
				pVO.setTaggedDate(rs.getDate("TAGGED_DATE"));
				pVO.setQuantity(rs.getInt("QUANTITY"));
				alPVO.add(pVO);
			}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		   {
		    try
		    {
		    	 if(rs != null)
		    		 rs.close();
		    	 if(pstmt != null)
		    		 pstmt.close();
		    	 if(con != null)
		    		 con.close();
		    	 System.out.println("Connection  closed");

		    }
		    catch(SQLException e)
		    {
		    	System.out.println("Connection not closed");
		    	e.printStackTrace();
		    }
		   }
		return alPVO;
	}
	//This method is used to sort the product model table based on productmodel ID by descending order
	public ArrayList<ProductModelVO> sortByIdDes()
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		try
		{
		con=getConnection();
		pstmt=con.prepareStatement(QueryConstants.SORTBYIDDESP);
		rs=pstmt.executeQuery();
			while(rs.next())
			{
				pVO = new ProductModelVO();
				pVO.setProductModelId(rs.getInt("PRODUCTMODEL_ID"));
				pVO.setProductModelName(rs.getString("PRODUCTMODEL_NAME"));
				pVO.setProductModelDescription(rs.getString("PRODUCTMODEL_DESCRIPTION"));
				pVO.setProductModelFeatures(rs.getString("PRODUCTMODEL_FEATURES"));
				pVO.setProductModelPrice(rs.getFloat("PRODUCTMODEL_PRICE"));
				pVO.setProductModelThreshold(rs.getInt("PRODUCTMODEL_THRESHOLD"));
				pVO.setRetailerID(rs.getInt("RETAILER_ID"));
				pVO.setTaggedDate(rs.getDate("TAGGED_DATE"));
				pVO.setQuantity(rs.getInt("QUANTITY"));
				alPVO.add(pVO);
			}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		   {
		    try
		    {
		    	 if(rs != null)
		    		 rs.close();
		    	 if(pstmt != null)
		    		 pstmt.close();
		    	 if(con != null)
		    		 con.close();
		    	 System.out.println("Connection  closed");

		    }
		    catch(SQLException e)
		    {
		    	System.out.println("Connection not closed");
		    	e.printStackTrace();
		    }
		   }
		return alPVO;
	}
	//This method is used to sort the product model table based on quantity by ascending order
	public ArrayList<ProductModelVO> sortByAmountAsc()
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		try
		{
		con=getConnection();
		pstmt=con.prepareStatement(QueryConstants.SORTBYQUANTITYASC);
		rs=pstmt.executeQuery();
			while(rs.next())
			{
				pVO = new ProductModelVO();
				pVO.setProductModelId(rs.getInt("PRODUCTMODEL_ID"));
				pVO.setProductModelName(rs.getString("PRODUCTMODEL_NAME"));
				pVO.setProductModelDescription(rs.getString("PRODUCTMODEL_DESCRIPTION"));
				pVO.setProductModelFeatures(rs.getString("PRODUCTMODEL_FEATURES"));
				pVO.setProductModelPrice(rs.getFloat("PRODUCTMODEL_PRICE"));
				pVO.setProductModelThreshold(rs.getInt("PRODUCTMODEL_THRESHOLD"));
				pVO.setRetailerID(rs.getInt("RETAILER_ID"));
				pVO.setTaggedDate(rs.getDate("TAGGED_DATE"));
				pVO.setQuantity(rs.getInt("QUANTITY"));
				alPVO.add(pVO);
			}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		   {
		    try
		    {
		    	 if(rs != null)
		    		 rs.close();
		    	 if(pstmt != null)
		    		 pstmt.close();
		    	 if(con != null)
		    		 con.close();
		    	 System.out.println("Connection  closed");

		    }
		    catch(SQLException e)
		    {
		    	System.out.println("Connection not closed");
		    	e.printStackTrace();
		    }
		   }
		return alPVO;
	}
//This method is used to sort the product model table based on quantity by descending order
	public ArrayList<ProductModelVO> sortByAmountDes()
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		try
		{
		con=getConnection();
		pstmt=con.prepareStatement(QueryConstants.SORTBYQUANTITYDES);
		rs=pstmt.executeQuery();
			while(rs.next())
			{
				pVO = new ProductModelVO();
				pVO.setProductModelId(rs.getInt("PRODUCTMODEL_ID"));
				pVO.setProductModelName(rs.getString("PRODUCTMODEL_NAME"));
				pVO.setProductModelDescription(rs.getString("PRODUCTMODEL_DESCRIPTION"));
				pVO.setProductModelFeatures(rs.getString("PRODUCTMODEL_FEATURES"));
				pVO.setProductModelPrice(rs.getFloat("PRODUCTMODEL_PRICE"));
				pVO.setProductModelThreshold(rs.getInt("PRODUCTMODEL_THRESHOLD"));
				pVO.setRetailerID(rs.getInt("RETAILER_ID"));
				pVO.setTaggedDate(rs.getDate("TAGGED_DATE"));
				pVO.setQuantity(rs.getInt("QUANTITY"));
				alPVO.add(pVO);
			}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		   {
		    try
		    {
		    	 if(rs != null)
		    		 rs.close();
		    	 if(pstmt != null)
		    		 pstmt.close();
		    	 if(con != null)
		    		 con.close();
		    	 System.out.println("Connection  closed");

		    }
		    catch(SQLException e)
		    {
		    	System.out.println("Connection not closed");
		    	e.printStackTrace();
		    }
		   }
		return alPVO;
	}
	public ArrayList<ProductModelVO> viewThreshold()
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		try
		{
		con=getConnection();
		pstmt=con.prepareStatement(QueryConstants.VIEWTHRESHOLD);
		rs=pstmt.executeQuery();
			while(rs.next())
			{
				pVO=new ProductModelVO();
				pVO.setProductModelId(rs.getInt("productmodel_id"));
				//System.out.println("kjki"+rs.getInt("productmodel_id"));
				pVO.setProductModelThreshold(rs.getInt("productmodel_threshold"));
				pVO.setQuantity(rs.getInt("quantity"));
				alPVO.add(pVO);
			}
		}
		catch(SQLException e)
	    {
	    	System.out.println("Connection not closed");
	    	e.printStackTrace();
	    }
		return alPVO;
	}
}
