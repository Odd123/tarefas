package br.usjt.projeto.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}
	}
	
	public static Connection conectar() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost/mydb?useTimezone=true&serverTimezone=UTC", "root", "Vi123578963");
	}
}
