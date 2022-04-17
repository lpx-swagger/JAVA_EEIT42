package Generator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

// 只要有 AutoCloseable 都可以這樣使用 
	// ex. Connection => AutoCloseable 可以自動關閉 => 不關也沒關係，他會自動關閉

public class chloe891 {
	public static void main(String[] args) {
		// 2. Create Connection
		
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		
		try(Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3307/iii", prop)) {
		
//		放進 try() 裡面的敘述句一定要是 AutoCloseable 才可以放進去，以下為錯誤示範
//		try(Connection conn = DriverManager.getConnection(
//				"jdbc:mysql://localhost:3307/iii", prop); System.out.println("OK");) {
		
			
			// 3. SQL statement => ? 是為了防止隱碼攻擊
//			PreparedStatement pstmt = conn.prepareStatement(
//					"UPDATE foods SET name = ?, tel = ? WHERE id = ?");
//			pstmt.setString(1, "小坑休閒農");
//			pstmt.setString(2, "321");
//			pstmt.setInt(3, 133);

			PreparedStatement pstmt = conn.prepareStatement(
					"DELETE FROM foods WHERE id = ?");
			pstmt.setInt(1, 133);
			
			// 4. execute SQL statement
			pstmt.executeUpdate();
			
			//conn.close();
			System.out.println("OK");
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
	}

}
