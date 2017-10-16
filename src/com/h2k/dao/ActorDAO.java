package com.h2k.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Properties;


/**
 * Write a Servlet with URL - TestSeptWeb/jdbc
 * @author Rishi
 *
 */

public class ActorDAO {
	
	private static String URL = "jdbc:mysql://localhost:3306/sakila";
	private static String QUERY = "select * from actor";
	private static String paramQuery = "select actor_id, first_name, last_name from actor where actor_id = ? ";
	private static String paramQuery2 = "select actor_id, first_name, last_name from actor where first_name like ?  and actor_id = ? ";

	private static String updateQuery = "Update actor set first_name = ? where actor_id = ?";
	private static String insertQuery = ""
			+ "INSERT INTO actor (actor_id, first_name, last_name, last_update) "
			+ "VALUES "
			+ "(?,?,?,CURRENT_TIMESTAMP);";
	
	public static void main(String[] args) {
		try {
			ActorDAO actorDao = new ActorDAO();
			//actorDao.printOneActor("A%", 173);
			//actorDao.scrollableResultSet();
			actorDao.insertStatement(2002, "David", "Bulson");
			//actorDao.updateQuery("Neil", 2000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	private void insertStatement(int actor_Id, String firstName, String lastName) throws Exception{
		// Step 1 - Adding a Driver
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		// Step 2 - Give it to Driver Manager
		// Step 3 - Connection
		Properties props = new Properties();
		props.setProperty("user", "root");
		props.setProperty("Password", "password");
		Connection conn = DriverManager.getConnection(URL,props);
		
		conn.setAutoCommit(false);
		
		PreparedStatement pStat = conn.prepareStatement(insertQuery);
		pStat.setInt(1, actor_Id);
		pStat.setString(2, firstName);
		pStat.setString(3, lastName);

		int rowsAffected = pStat.executeUpdate();
		
		conn.commit();
		
		// opposite of conn.rollback() - reverts upto last commit
		System.out.println("Number of Rows affected :: " + rowsAffected);
		conn.close();
	}
	
	
	private void updateQuery(String firstName, int actor_Id) throws Exception{
		// Step 1 - Adding a Driver
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		// Step 2 - Give it to Driver Manager
		// Step 3 - Connection
		Properties props = new Properties();
		props.setProperty("user", "root");
		props.setProperty("Password", "password");
		Connection conn = DriverManager.getConnection(URL,props);
		
		PreparedStatement pStat = conn.prepareStatement(updateQuery);
		pStat.setString(1, firstName);
		pStat.setInt(2, actor_Id);
		
		int rowsAffected = pStat.executeUpdate();
		
		System.out.println("Number of Rows affected :: " + rowsAffected);
		conn.close();
	}
	
	private void scrollableResultSet() throws Exception{
		// Step 1 - Adding a Driver
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		// Step 2 - Give it to Driver Manager
		// Step 3 - Connection
		Properties props = new Properties();
		props.setProperty("user", "root");
		props.setProperty("Password", "password");
		Connection conn = DriverManager.getConnection(URL,props);
		
		Statement stat = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = stat.executeQuery(QUERY);
		
		String firstName =  null;
		String lastName = null;
		Timestamp timestamp = null;
		if(rs != null){
			boolean ifLast = rs.last();
			
			while(rs.previous()){
				int actorId = rs.getInt("actor_id");
				firstName = rs.getString("first_name");
				lastName = rs.getString("last_name");
				timestamp = rs.getTimestamp("last_update");
				
				int rowId = rs.getRow();
				System.out.println("Get Row :: "  + rowId);
				
				if(rowId == 12){
					rs.relative(-3);
				}
				
				System.out.println(" actorId :: " + actorId + " firstName :: " + firstName + " lastName " + lastName + " timestamp " + timestamp);
			}
		}
		conn.close();
	}
	
	
	private void updatableResultSet() throws Exception{
		// Step 1 - Adding a Driver
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		// Step 2 - Give it to Driver Manager
		// Step 3 - Connection
		Properties props = new Properties();
		props.setProperty("user", "root");
		props.setProperty("Password", "password");
		Connection conn = DriverManager.getConnection(URL,props);
		
		Statement stat = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = stat.executeQuery(QUERY);
		
		String firstName =  null;
		String lastName = null;
		Timestamp timestamp = null;
		while(rs.next()){
			int actorId = rs.getInt("actor_id");
			firstName = rs.getString("first_name");
			lastName = rs.getString("last_name");
			timestamp = rs.getTimestamp("last_update");
			
			int rowId = rs.getRow();
			System.out.println("Get Row :: "  + rowId);
			
			if(rowId == 12){
				rs.updateString("first_name", "PEARL");
				rs.updateRow();
			}
			
			System.out.println(" actorId :: " + actorId + " firstName :: " + firstName + " lastName " + lastName + " timestamp " + timestamp);
		}
		conn.close();
	}
	
	private void printOneActor(String firstName, int actor_id) throws Exception{
		// Step 1 - Adding a Driver
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		// Step 2 - Give it to Driver Manager
		// Step 3 - Connection
		Properties props = new Properties();
		props.setProperty("user", "root");
		props.setProperty("Password", "password");
		Connection conn = DriverManager.getConnection(URL,props);
		
		PreparedStatement pStat = conn.prepareStatement(paramQuery2);
		pStat.setString(1, firstName);
		pStat.setInt(2, actor_id);
		
		ResultSet rs = pStat.executeQuery();

		String lastName = null;
		String actorName = null;
		
		while(rs.next()){
			int actorId = rs.getInt("actor_id");
			actorName = rs.getString("first_name");
			lastName = rs.getString("last_name");
			System.out.println(" actorId :: " + actorId + " actorName :: " + actorName + " lastName " + lastName );
		}
				
		System.out.println("ResultSet rs  :: " + rs);
		conn.close();
		
	}
	
	private void printOneActor(int acotr_id) throws Exception{
		// Step 1 - Adding a Driver
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		// Step 2 - Give it to Driver Manager
		// Step 3 - Connection
		Properties props = new Properties();
		props.setProperty("user", "root");
		props.setProperty("Password", "password");
		Connection conn = DriverManager.getConnection(URL,props);
		
		PreparedStatement pStat = conn.prepareStatement(paramQuery);
		pStat.setInt(1, acotr_id);
		
		ResultSet rs = pStat.executeQuery();
		String firstName =  null;
		String lastName = null;
		
		while(rs.next()){
			int actorId = rs.getInt("actor_id");
			firstName = rs.getString("first_name");
			lastName = rs.getString("last_name");
			System.out.println(" actorId :: " + actorId + " firstName :: " + firstName + " lastName " + lastName );
		}
				
		System.out.println("ResultSet rs  :: " + rs);
		conn.close();
		
	}
	
	
	
	private void printAllActors() throws Exception{
		// Step 1 - Adding a Driver
		// A -normal instantiation 
		// Driver driver = new Driver();
		Class.forName("com.mysql.cj.jdbc.Driver"); // reflection way for creating instance
		// Step 2 - Give it to Driver Manager
		// DriverManager.registerDriver(driver); // not needed if reflection is used
		
		// Step 3 - Connection
		Properties props = new Properties();
		props.setProperty("user", "root");
		props.setProperty("Password", "password");
		Connection conn = DriverManager.getConnection(URL,props);
		
		// Step 4 - Statement
		Statement stat = conn.createStatement();
		
		// Step 5 - Get the result back
		ResultSet rs = stat.executeQuery(QUERY);
		String firstName =  null;
		String lastName = null;
		Timestamp timestamp = null;
		while(rs.next()){
			int actorId = rs.getInt("actor_id");
			firstName = rs.getString("first_name");
			lastName = rs.getString("last_name");
			timestamp = rs.getTimestamp("last_update");
			System.out.println(" actorId :: " + actorId + " firstName :: " + firstName + " lastName " + lastName + " timestamp " + timestamp);
			
			int rowId = rs.getRow();
			if(rowId == 12){
				rs.updateString("first_name", "PEARL");
				rs.updateRow();
			}
		}
				
		System.out.println("ResultSet rs  :: " + rs);
		conn.close();
	}

}
