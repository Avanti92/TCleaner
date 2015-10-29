import javax.swing.*;

import org.sqlite.SQLiteConfig.JournalMode;

import java.sql.*;

public class SqliteConnect {
	
	Connection conn = null;
	public static Connection dbConnection(){
		try {
			
			Class.forName("org.sqlite.JDBC");
			Connection conn=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Yannik\\Desktop\\DatebaseAccess.sqlite");
			JOptionPane.showMessageDialog(null, "Datenbank geladen");
			return conn;
			
		} catch (Exception e) {
			
			JOptionPane.showMessageDialog(null, e);
			return null;
			
		}
		
	}
	

}
