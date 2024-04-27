package web1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DataBaseHelper {

	private static final String JDBC_URL = "jdbc:mysql://localhost:3003/biblioteca";
	private static final String USUARIO = "root";
	private static final String PASSWORD = "root";
	
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException { 
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(JDBC_URL, USUARIO, PASSWORD);
	}

	public static void close (
		Connection connection, 
		PreparedStatement preparedStatement, 
		ResultSet resultSet
		) {
			try {
				if(resultSet != null) {
					resultSet.close();
				}
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}

	public static int executeUpdate(String sql, Object ...paramseters) throws ClassNotFoundException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(sql);

			for(int i = 0; i < paramseters.length; i++) {
				preparedStatement.setObject(i+1, paramseters[i]);
			}
			return preparedStatement.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {
			close(connection, preparedStatement, null);
		}
	}

	public static ResultSet executeQuery(String sql, Object ...parameters) throws ClassNotFoundException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(sql);
			for(int i = 0; i < parameters.length; i++) {
				preparedStatement.setObject(i + 1, parameters[i]);
			}
			return preparedStatement.executeQuery();
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
