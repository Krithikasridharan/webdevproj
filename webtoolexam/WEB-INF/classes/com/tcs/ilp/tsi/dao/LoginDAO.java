package com.tcs.ilp.tsi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tcs.ilp.tsi.connection.ConnectionFactory;
import com.tcs.ilp.tsi.util.QueryConstants;
import com.tcs.ilp.tsi.vo.LoginVO;

public class LoginDAO {
	private Connection getConnection() throws SQLException
	{
		Connection con;
		con=ConnectionFactory.getInstance().getConnection();
		return con;
		
	}
	public ResultSet loginPage(LoginVO vo)
	{
		ResultSet rs=null;
		try
		{
			Connection con=getConnection();
			PreparedStatement pstmt=con.prepareStatement(QueryConstants.LOGINQUERY);
			pstmt.setString(1, vo.getUser_name());
			pstmt.setString(2, vo.getPassword());
			rs=pstmt.executeQuery();
			
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}

}
