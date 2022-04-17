package Class;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import javax.swing.JOptionPane;

public class SQLconnection {
	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");

		try {
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3307/iii", prop);
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
}
