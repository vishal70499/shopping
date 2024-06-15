package com.amstech.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBUtil {
	private final String URL = "jdbc:mysql://localhost:3306/ospjsp";
	private final String USERNAME = "root";
	private final String PASSWARD = "root";
	private final String DRIVER = "com.mysql.cj.jdbc.Driver";

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER);
		Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWARD);
		System.out.println("Connecting Successfully");
		return connection;
	}

	public void getClose(Connection connection, PreparedStatement preparedStatement) throws SQLException {
		connection.close();
		preparedStatement.close();
		System.out.println("Closing Mysql Connection..");
	}

}