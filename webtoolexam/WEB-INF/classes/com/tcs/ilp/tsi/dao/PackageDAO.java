package com.tcs.ilp.tsi.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import com.tcs.ilp.tsi.connection.*;
import com.tcs.ilp.tsi.util.QueryConstants;
import com.tcs.ilp.tsi.vo.PackageVO;
import com.tcs.ilp.tsi.vo.RewardVO;


public class PackageDAO {

	RewardVO rVO;
	ArrayList<RewardVO> alRVO=new ArrayList<RewardVO>();
	PackageVO pVO;
	ArrayList<PackageVO> alPVO=new ArrayList<PackageVO>();
	
	
	
private Connection getConnection() throws SQLException

{
	
	Connection con;
	con=ConnectionFactory.getInstance().getConnection();
	return con;
	
}





	public int addPackage(PackageVO vo){
		int count=0;
		Connection con = null;
		PreparedStatement pstmt = null;
		try
		{
			con=getConnection();
			pstmt=con.prepareStatement(QueryConstants.ADDPACKAGE);
			pstmt.setString(1,vo.getOffers());
			pstmt.setFloat(2,vo.getAmount());
			count=pstmt.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		   {
		    try
		    {
		    	 
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
		
		return count;
	}
	
	
	
	
		
	public ArrayList<PackageVO> viewPackage()
	{
		Connection con = null;
		Statement stmt = null;
		ResultSet rs=null;

		try
		{
			con=getConnection();
			stmt=con.createStatement();
			rs=stmt.executeQuery(QueryConstants.VIEWPACKAGE);
			while(rs.next())
			{
				pVO=new PackageVO();
				pVO.setPackage_id(rs.getInt("package_id"));
				pVO.setOffers(rs.getString("offers"));
				pVO.setAmount(rs.getFloat("amount"));
				alPVO.add(pVO);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally
		   {
		    try
		    {
		    	 if(rs != null)
		    		 rs.close();
		    	 if(stmt != null)
		    		 stmt.close();
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
	
	
	
	
	
	public ArrayList<PackageVO> viewPackageId()
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;

		try{
			con=getConnection();
			pstmt=con.prepareStatement(QueryConstants.VIEWPACKAGEID);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				pVO=new PackageVO();
				pVO.setPackage_id(rs.getInt("package_id"));
				alPVO.add(pVO);
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
	
	
	
	
	
	public ArrayList<PackageVO> findPackage(PackageVO vo)
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		try
		{
			con=getConnection();
			pstmt=con.prepareStatement(QueryConstants.FINDPACKAGE);
			pstmt.setInt(1, vo.getPackage_id());
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				pVO=new PackageVO();
				pVO.setOffers(rs.getString("offers"));
				pVO.setAmount(rs.getFloat("amount"));
				alPVO.add(pVO);
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
	
	
	
	
	
	public int updatePackage(PackageVO vo)
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		
		int count=0;
		try
		{
			con=getConnection();
			pstmt=con.prepareStatement(QueryConstants.UPDATEPACKAGE);
			pstmt.setString(1,vo.getOffers());
			pstmt.setFloat(2, vo.getAmount());
			pstmt.setInt(3,vo.getPackage_id());
			
			count=pstmt.executeUpdate();
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		   {
		    try
		    {
		    	 
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
		return count;
	}

	
	
	
	
	public int deletePackage(int id)
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		int count=0;
		try
		{
			con=getConnection();
			pstmt=con.prepareStatement(QueryConstants.DELETEPACKAGE);
			pstmt.setInt(1, id);
			count=pstmt.executeUpdate();
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		   {
		    try
		    {
		    	 
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
		return count;
	}
	
	
	
	
	
	public ArrayList<RewardVO> viewRewards()
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		try{
				con=getConnection();
				pstmt=con.prepareStatement(QueryConstants.VIEWREWARDS);
				rs=pstmt.executeQuery();
				while(rs.next())
				{
					rVO=new RewardVO();
					rVO.setRewardID(rs.getInt("reward_id"));
					rVO.setRetailerID(rs.getInt("retailer_id"));
					rVO.setPackageID(rs.getInt("package_id"));
					rVO.setRewardDate(rs.getDate("reward_date"));
					rVO.setRewardStatus(rs.getString("reward_status"));
					alRVO.add(rVO);
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
		    	 System.out.println("Connection  closed");

		    }
		    catch(SQLException e)
		    {
		    	System.out.println("Connection not closed");
		    	e.printStackTrace();
		    }
		   }
		return alRVO;
	}
	
	
	
	
	
	public ArrayList<PackageVO> sortByIdAsc()
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		try
		{
		con=getConnection();
		pstmt=con.prepareStatement(QueryConstants.SORTBYIDASC);
		rs=pstmt.executeQuery();
			while(rs.next())
			{
			pVO=new PackageVO();
			pVO.setPackage_id(rs.getInt("package_id"));
			pVO.setOffers(rs.getString("offers"));
			pVO.setAmount(rs.getFloat("amount"));
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
	
	
	
	
	
	public ArrayList<PackageVO> sortByIdDes()
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		try
		{
		con=getConnection();
		pstmt=con.prepareStatement(QueryConstants.SORTBYIDDES);
		rs=pstmt.executeQuery();
			while(rs.next())
			{
			pVO=new PackageVO();
			pVO.setPackage_id(rs.getInt("package_id"));
			pVO.setOffers(rs.getString("offers"));
			pVO.setAmount(rs.getFloat("amount"));
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
	
	
	
	
	
	public ArrayList<PackageVO> sortByAmountAsc()
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		try
		{
		con=getConnection();
		pstmt=con.prepareStatement(QueryConstants.SORTBYAMOUNTASC);
		rs=pstmt.executeQuery();
			while(rs.next())
			{
			pVO=new PackageVO();
			pVO.setPackage_id(rs.getInt("package_id"));
			pVO.setOffers(rs.getString("offers"));
			pVO.setAmount(rs.getFloat("amount"));
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
	
	
	
	
	
	public ArrayList<PackageVO> sortByAmountDes()
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		try
		{
		con=getConnection();
		pstmt=con.prepareStatement(QueryConstants.SORTBYAMOUNTDES);
		rs=pstmt.executeQuery();
			while(rs.next())
			{
			pVO=new PackageVO();
			pVO.setPackage_id(rs.getInt("package_id"));
			pVO.setOffers(rs.getString("offers"));
			pVO.setAmount(rs.getFloat("amount"));
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
	
}