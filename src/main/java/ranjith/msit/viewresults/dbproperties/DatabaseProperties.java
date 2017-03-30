package ranjith.msit.viewresults.dbproperties;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class DatabaseProperties {

	private Connection connection = null;
	public Connection openConnectionToDB() throws ClassNotFoundException, SQLException{
		
		Class.forName("com.mysql.jdbc.Driver");
		/*String host = System.getenv("localhost");
		String port = System.getenv("3308");*/
		System.out.println("In DB Class");
		connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3308/msit_results", "root", "ranjith");
		return connection;
		
	}
	public void closeConnection(Connection connection){
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
