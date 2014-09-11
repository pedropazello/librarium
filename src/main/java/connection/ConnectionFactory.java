package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection() {
		
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}  
			String address 	= "jdbc:mysql://localhost:3306/librarium2";
			String login 	= "root";
			String password = "root";
			return DriverManager.getConnection(address, login, password);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
