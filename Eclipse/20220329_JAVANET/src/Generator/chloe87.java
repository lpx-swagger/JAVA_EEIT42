package Generator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

// 有 port number, 也要有人listen => 才會有response => 你才再繼續下 request
// Properties => 比起 chloe86.java, chloe861.java 這個彈性高

public class chloe87 {
	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		
		// 2. Create Connection
		try {
			
			// Method1: chloe86.java
			// Connection conn = DriverManager.getConnection(
			// "jdbc:mysql://localhost/iii?user=root&password=root");

			// Method2: chloe861.java
			// Connection conn = DriverManager.getConnection(
			// "jdbc:mysql://localhost/iii", "root", "root");

			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3307/iii", prop);

			// 3. SQL statement => 使用 PreparedStatement 和 ? 預存的方式來防止隱碼攻擊(SQL Injection)
			PreparedStatement pstmt = conn.prepareStatement(
					"INSERT INTO cust (name,tel,birthday) " +
					"VALUES (?,?,?)");
			
			// 重新 set 新值
			pstmt.setString(1, "tony");
			pstmt.setString(2, "0931432379");
			pstmt.setString(3, "1988-02-03");

			// 4. execute SQL statement
			pstmt.executeUpdate();


			conn.close();
			System.out.println("OK3");
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
	}

}
