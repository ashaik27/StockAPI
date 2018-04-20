package stock.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This program demonstrates how to establish database connection to Microsoft
 * SQL Server.
 * 
 * @author Amanulla Shaik
 *
 */
public class DBUtil {
	static Connection conn = null;
	static Statement statement;
	static ResultSet resultSet;

	public static Connection connect() {

		try {
			String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=StockDB";
			String user = "aman";
			String pass = "*******"; // password commented for security reasons

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			conn = DriverManager.getConnection(dbURL, user, pass);

		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 

		return conn;
	}

	public static ResultSet getResultSet(String query) {
		try {
			conn = DBUtil.connect();
			statement = conn.createStatement();
			resultSet = statement.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultSet;
	}

}