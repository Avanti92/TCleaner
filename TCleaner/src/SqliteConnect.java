

import javax.swing.*;
import java.sql.*;

public class SqliteConnect {
	
	Connection conn = null;
	public static Connection dbConnection(){
		try {
			
			Class.forName("org.sqlite.JDBC");
			Connection conn=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Yannik\\Desktop\\localsql.sqlite");
			JOptionPane.showMessageDialog(null, "Access granted");
			return conn;
			
		} catch (Exception e) {
			
			JOptionPane.showMessageDialog(null, e);
			return null;
			
		}
		
	}
	

}
