package com.tcs.ilp.tsi.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.tcs.ilp.tsi.util.Constants;


public class ConnectionFactory {

	String driverName = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/";
	String dbName = "db";
	String userName = "root";
	String password = "root";	
	private static ConnectionFactory connectionMaker = null;
	
	private ConnectionFactory() 
	{
		driverName = "com.mysql.jdbc.Driver";
		url = "jdbc:mysql://localhost:3306/";
		dbName = "db";
		userName = "root";
		password = "root";
		try
		{
			Class.forName(driverName);
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	public Connection getConnection() throws SQLException
	{
		Connection conn = null;

		conn = (Connection) DriverManager.getConnection(url+dbName,userName,password);
		return conn;
	}
	
	
	 public static ConnectionFactory getInstance()
	 {
		 if(connectionMaker == null)
		 {
			 connectionMaker = new ConnectionFactory();
		 }
		 return connectionMaker;
	 }
	 
	 
	
}
