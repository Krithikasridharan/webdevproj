package com.tcs.ilp.tsi.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tcs.ilp.tsi.connection.ConnectionFactory;
import com.tcs.ilp.tsi.util.QueryConstants;
import com.tcs.ilp.tsi.vo.StockVO;



public class StockDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt1=null;
	ResultSet rs = null;
	int a=0;
	public StockDAO()
	{
		
	}

	private Connection getConnection() throws SQLException
	{
		 Connection conn;
		 conn=ConnectionFactory.getInstance().getConnection();
		 return conn;
	}
	
	
	
	
	public int add(StockVO svo)
	{
		int i=0;
		try
		{
			//String ADDSTOCK = "INSERT INTO PRODUCT_STOCK_TBL(PRODUCT_CODE, PRODUCTMODEL_ID,PRODUCT_NAME,PRODUCT_STATUS) values(Stock_Seq.nextval,?,?,?)";
			con = getConnection();
			pstmt = con.prepareStatement(QueryConstants.ADDSTOCK);
			pstmt.setInt(1,svo.getProduct_ModelID());
			pstmt.setString(2, svo.getProductName());
			pstmt.setString(3, svo.getProductStatus());					
			 i=pstmt.executeUpdate();
		
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
		    }}
		    return i;
		   
	}
	public void incrementquantity(StockVO svo)
	{
		try{
	    int quantity=0;
		//String INCREMENT_QUANTITY="SELECT * FROM INVENTORY_TBL WHERE PRODUCTMODEL_ID=?";
		//String UPDATE_QUANTITY="UPDATE INVENTORY_TBL SET QUANTITY=? WHERE PRODUCTMODEL_ID=?";
		con=getConnection();
		pstmt=con.prepareStatement(QueryConstants.INCREMENTQUANTITY);
		pstmt.setInt(1,svo.getProduct_ModelID());
		rs=pstmt.executeQuery();
		while(rs.next())
		{
		quantity=rs.getInt("QUANTITY")	;
		}
		quantity++;
		pstmt=con.prepareStatement(QueryConstants.UPDATEQUANTITY);
		pstmt.setInt(1,quantity);
		pstmt.setInt(2,svo.getProduct_ModelID());
		pstmt.executeUpdate();
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
		    }}
		}
	public void decrementquantity(int pmid)
	{
		try
		{
			int quantity=0;
			//String DECREMENT_QUANTITY="SELECT QUANTITY FROM INVENTORY_TBL WHERE PRODUCTMODEL_ID=?";
			//String UPDATE_QUANTITY="UPDATE INVENTORY_TBL SET QUANTITY=? WHERE PRODUCTMODEL_ID=?";
			con=getConnection();
			pstmt=con.prepareStatement(QueryConstants.DECREMENTQUANTITY);
			pstmt.setInt(1,pmid);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				quantity=rs.getInt("QUANTITY");
			}
			quantity--;
			pstmt=con.prepareStatement(QueryConstants.UPDATEQUANTITY);				
			pstmt.setInt(1,quantity);
			pstmt.setInt(2,pmid);
			pstmt.executeUpdate();
			}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	public int delete(int pc) 
	{
		
		{
		try
		{
			
		//String FIND_STOCK="SELECT * FROM PRODUCT_STOCK_TBL WHERE PRODUCT_CODE=?";
		
		con=getConnection();
		PreparedStatement st=con.prepareStatement(QueryConstants.FINDSTOCK);
		st.setInt(1,pc);
		rs=st.executeQuery();
		int pmID=0;
		String ps=null;
		if(rs.next())
		{
			pmID=rs.getInt("PRODUCTMODEL_ID");
			ps=rs.getString("PRODUCT_STATUS");
		}
		
			//String SELECT_QUANTITY="SELECT QUANTITY FROM INVENTORY_TBL WHERE PRODUCTMODEL_ID=?";
		
		PreparedStatement st1=con.prepareStatement(QueryConstants.SELECT_QUANTITY);
		st1.setInt(1,pmID);
		
		ResultSet rs1=st1.executeQuery();
		int quantity=0;
		if(rs1.next())
		{
			quantity=rs1.getInt("QUANTITY");
		}
		
		if((ps.equalsIgnoreCase("available"))&&(quantity!=0))
		{
			//String DELETE_STOCK = "DELETE FROM PRODUCT_STOCK_TBL WHERE PRODUCT_CODE=?";
			
			con = getConnection();
			pstmt=con.prepareStatement(QueryConstants.DELETE_STOCK);
			pstmt.setInt(1,pc);
			a=pstmt.executeUpdate();
			decrementquantity(pmID);
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
	
	}
	return a;
}
	
	
	public int update(StockVO svo)
	{
		
		try
		{
							
			//String UPDATE_STOCK ="UPDATE PRODUCT_STOCK_TBL SET PRODUCT_NAME = ?,PRODUCT_STATUS = ? WHERE PRODUCT_CODE = ?";
			con = getConnection();					
			pstmt = con.prepareStatement(QueryConstants.UPDATESTOCK);			
			pstmt.setString(1, svo.getProductName());
			pstmt.setString(2, svo.getProductStatus());
			pstmt.setInt(3, svo.getProductCode());
			 a=pstmt.executeUpdate();		
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
		return a;
	}
	public StockVO Select(StockVO svo)
	{ StockVO svo1=new StockVO();
		try	
	{
	   con=getConnection();
		//String FIND_STOCK="SELECT * FROM PRODUCT_STOCK_TBL WHERE PRODUCT_CODE=?";
		System.out.println(svo.getProductCode());
		pstmt1=con.prepareStatement(QueryConstants.FINDSTOCK);
		pstmt1.setInt(1,svo.getProductCode());
		rs=pstmt1.executeQuery();
		while(rs.next())
		{
		svo1.setProductCode(rs.getInt("PRODUCT_CODE"));
		svo1.setProductName(rs.getString("PRODUCT_NAME"));
		svo1.setProduct_ModelID(rs.getInt( "PRODUCTMODEL_ID"));
		svo1.setProductStatus(rs.getString("PRODUCT_STATUS"));
		svo1.setOrder_ID(rs.getInt("ORDER_ID"));
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
		
		return svo1;
		}
	public int checkupdate(StockVO svo1)
	{
	String s;
	
		try
		{
			con=getConnection();
			//String SELECT_PRODUCTSTATUS="SELECT PRODUCT_STATUS FROM PRODUCT_STOCK_TBL WHERE PRODUCTMODEL_ID=?";				
			pstmt1=con.prepareStatement(QueryConstants.SELECTPRODUCTSTATUS);
			pstmt1.setInt(1,svo1.getProduct_ModelID());
			rs=pstmt1.executeQuery();
			while(rs.next())
			{
				s=rs.getString("PRODUCT_STATUS");
				System.out.println(s);
			if(s.equalsIgnoreCase("available"))
				a=1;
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
	
		return a;
	}
	public List<StockVO> viewproductid()
	{
		List<StockVO> ProductIDList=new ArrayList<StockVO>();
		StockVO StockVObj=null;
		try
		{
		//String SELECT_PRODUCTCODE="SELECT PRODUCT_CODE FROM PRODUCT_STOCK_TBL";
		con=getConnection();
		Statement stmt=con.createStatement();
		rs=stmt.executeQuery(QueryConstants.SELECTPRODUCTCODE);
		while(rs.next())
		{
			StockVObj=new StockVO();
			StockVObj.setProductCode(rs.getInt("PRODUCT_CODE"));
			ProductIDList.add(StockVObj);
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
		return ProductIDList;
	}
	public List<StockVO> viewAll()
	{
		List<StockVO> StockList = new ArrayList<StockVO>();
		StockVO StockVObj = null;
		Connection con = null;
		try
		{
			con=getConnection();
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(QueryConstants.VIEW);				
			while(rs.next())
			{
				StockVObj = new StockVO();
				StockVObj.setProductCode(rs.getInt(1));
				StockVObj.setProduct_ModelID(rs.getInt(2));
				StockVObj.setProductName(rs.getString(3));
				StockVObj.setProductStatus(rs.getString(4));
				StockVObj.setOrder_ID(rs.getInt(5));
				StockList.add(StockVObj);
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
		return StockList;
	}

	public List<StockVO> SortbyProductCodeascending()
	{
		 List<StockVO> Sortedstock=new ArrayList<StockVO>();
         StockVO StockVObj=null;
         		try
         		{
       // String SORT_ASCENDING="SELECT * FROM PRODUCT_STOCK_TBL ORDER BY PRODUCT_CODE";
        con=getConnection();
        Statement stmt=con.createStatement();
       con=getConnection();
      
        rs=stmt.executeQuery(QueryConstants.SORTASCENDING);
        while(rs.next())
        {
        StockVObj=new StockVO();
        StockVObj.setProductCode(rs.getInt("PRODUCT_CODE"));
        StockVObj.setProduct_ModelID(rs.getInt("PRODUCTMODEL_ID"));
        StockVObj.setProductName(rs.getString("PRODUCT_NAME"));
        StockVObj.setProductStatus(rs.getString("PRODUCT_STATUS"));
        StockVObj.setOrder_ID(rs.getInt("ORDER_ID"));
        
        Sortedstock.add(StockVObj);
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
	return Sortedstock;
	}
	public List<StockVO> SortbyProductCodedescending()
	{
		 List<StockVO> Sortedstock=new ArrayList<StockVO>();
         StockVO StockVObj=null;
         		try
         		{
        //String SORT_DESCENDING="SELECT * FROM PRODUCT_STOCK_TBL ORDER BY PRODUCT_CODE DESC";
        con=getConnection();
        Statement stmt=con.createStatement();
       con=getConnection();
      
        rs=stmt.executeQuery(QueryConstants.SORTDESCENDING);
        while(rs.next())
        {
        StockVObj=new StockVO();
        StockVObj.setProductCode(rs.getInt("PRODUCT_CODE"));
        StockVObj.setProduct_ModelID(rs.getInt("PRODUCTMODEL_ID"));
        StockVObj.setProductName(rs.getString("PRODUCT_NAME"));
        StockVObj.setProductStatus(rs.getString("PRODUCT_STATUS"));
        StockVObj.setOrder_ID(rs.getInt("ORDER_ID"));
        
        Sortedstock.add(StockVObj);
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
	return Sortedstock;
	}
}