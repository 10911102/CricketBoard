package com;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Get Connection from DriverManager
 * @author swapnilu
 *
 */
public class MysqlCon {
	/**
	 * Get Connection
	 * @return Connection object for database connection
	 * @throws Exception
	 */
	public static Connection getConnection() throws Exception {
			//Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/swapnil","root","root");
		return con;
	}

}
