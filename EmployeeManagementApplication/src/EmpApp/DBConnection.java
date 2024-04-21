package EmpApp;

import java.sql.*;

public class DBConnection {
    private static final String url = "jdbc:mysql://localhost:3306/projectsdb";
	private static final String userName = "root";
	private static final String passWord = "Vignesh@29";
	
	public static Connection createDBConnection() throws SQLException{
		return  DriverManager.getConnection(url,userName,passWord);
	}
}