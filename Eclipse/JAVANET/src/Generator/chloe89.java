package Generator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

// PreparedStatement
// 修！刪！

public class chloe89 {
	public static void main(String[] args) {
		// 2. Create Connection
		
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		
		try {
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3307/iii", prop);
			
			// 3. SQL statement => 使用 PreparedStatement 和 ? 預存的方式來防止隱碼攻擊(SQL Injection)
//			PreparedStatement pstmt = conn.prepareStatement(
//					"UPDATE foods SET name = ?, tel = ? WHERE id = ?");
//			pstmt.setString(1, "小坑休閒農");
//			pstmt.setString(2, "0931432379");
//			pstmt.setInt(3, 133);

			PreparedStatement pstmt = conn.prepareStatement(
					"DELETE FROM foods WHERE id = ?");
			pstmt.setInt(1, 133);
			
			// 4. execute SQL statement
			pstmt.executeUpdate();
			
			conn.close();
			System.out.println("OK");
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
	}

}
