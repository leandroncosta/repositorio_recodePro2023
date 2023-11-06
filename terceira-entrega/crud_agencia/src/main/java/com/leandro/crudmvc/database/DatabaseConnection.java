package com.leandro.crudmvc.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private static final String URL = "jdbc:mysql://localhost:3306/agencia_viagem";
	private static final String USER = "root";
	private static final String PASSWORD = "1234";

	public static Connection createConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			System.out.println("[log] driver found");
		} catch (ClassNotFoundException e) {
			System.out.println("[log] driver not found, Message: " + e.getMessage());
		}

		try {
			Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("[log] connected to database");

			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
			//throw new RuntimeException("Cannot connect to database" + e.getMessage());

			return null;
		}
	}

	public static void closeConnection(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException error) {
				error.printStackTrace();
			}
		}
	}

}
