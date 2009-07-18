package server;

import java.sql.SQLException;

import common.Singleton;

import repository.MySQLConnectionFacade;

/**
 * This class serves as the medium for all database
 * transactions needed by RPOS.  It maintains a
 * singular connection to the database.
 */
public class Database extends Singleton {
	private MySQLConnectionFacade mysql;
	private String serverName;
	private String databaseName;
	private String username;
	private String password;
	
	private Database() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		super();
		initialize();
		mysql = new MySQLConnectionFacade(serverName, databaseName, username, password);
	}
	
	/**
	 * Changes the status of an order.
	 * @param orderNumber the number of the order status to change
	 * @param updatedStatus the new status
	 */
	public void setOrderStatus(int orderNumber, String updatedStatus) {
		
	}
	
	/**
	 * Gets the status of an order.
	 * @param orderNumber the number of the order
	 */
	public String getOrderStatus(int orderNumber) {
		return ""; // TODO implement soon
	}
	
	/**
	 * Gets the order
	 * @param tableNumber
	 * @return
	 */
	public String getOrder(int tableNumber) {
		return ""; // TODO the order should be here
	}
	
	/**
	 * Sets an order to paid. 
	 * @param tableNumber the table that will be set to paid
	 */
	public void orderPaid(int tableNumber) {
		
	}
	
	/**
	 * Returns the password for a particular user.
	 * @param userName the username to get the password for
	 * @return the password that corresponds to the username
	 */
	public String getStoredPW(String userName) {
		return ""; // TODO the user password
	}
	
	/**
	 * Locks a user's account.
	 * @param userName the username
	 */
	public void lockAccount(String userName) {
		
	}
	
	public boolean isTableEmpty() {
		return false; // TODO: must implement
	}
	
	/**
	 * Marks a table as busy.
	 * @param tableNumber the table that will be marked as busy
	 */
	public void markAsBusy(int tableNumber) {
		
	}
	
	public void saveOrder(String orderInfo, int tablenumber) {
		
	}
	
	/**
	 * Opens a connection with the MySQL database.
	 * @throws SQLException
	 */
	public void open() throws SQLException {
		mysql.connect();
	}
	
	/**
	 * Closes a connection with the MySQL database.
	 * @throws SQLException
	 */
	public void close() throws SQLException {
		mysql.close();
	}
	
	/**
	 * Initializes this class's members to sane values.
	 */
	private void initialize() {
		// initialize the database's parameters
		serverName = "localhost";
		databaseName = "rpos";
		username = "rpos";
		password = "rpos";
	}
}
