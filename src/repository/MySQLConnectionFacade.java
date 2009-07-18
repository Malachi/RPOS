package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * A type designed to manage a MySQL database connection.
 */
public class MySQLConnectionFacade {
	private String serverName;
	private String databaseName;
	private String username;
	private String password;
	private Connection connection;
	
	public MySQLConnectionFacade(String serverName, String databaseName, String username, String password) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		super();
		
		this.serverName = serverName;
		this.databaseName = databaseName;
		this.username = username;
		this.password = password;
		
		initialize();
	}
	
	public void initialize() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
	}
	
	public void connect() throws SQLException {
		String databaseURL = "jdbc:mysql :// " + serverName + ":3306/" + databaseName;
		connection = DriverManager.getConnection(databaseURL, username, password);
	}
	
	public void query(String queryString) throws SQLException {
		Statement statement = connection.createStatement();
	    statement.executeUpdate(queryString);
	}
	
	public void close() throws SQLException {
		connection.close();
	}
}
