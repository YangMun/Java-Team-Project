package com.ysu.dbconnection;

import java.sql.*;

public class DBConnection {
	Connection conn =null;
	
	public Connection getDBConn() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  //com.mysql.cj.jdbc.Driver
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"
					+ "sampledb", "ysu","1234");
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 로드 에러");
		} catch (SQLException e) {
			System.out.println("DB 연결 오류");
		}
		return conn;
	}
}
