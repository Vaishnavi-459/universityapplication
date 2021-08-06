package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {
	private final static String driver = "com.mysql.cj.jdbc.Driver";
	private final static String url = "jdbc:mysql://localhost:3306/universityapplication";
	private final static String user = "root";
	private final static String password = "2718";

	public JdbcConnection() {

	}

	private static Connection con = null;

	public static Connection getConnection() {

		try {
			if (con == null) {
				try {
					Class.forName(driver);
					System.out.println("Connection is established...You can control your database");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				con = DriverManager.getConnection(url, user, password);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;

	}
}
