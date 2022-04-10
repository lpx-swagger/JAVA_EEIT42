package Generator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

// 載入驅動程式 connector
//Statement => 最原始的觀念； 盡量使用 PreparedStatement 來做

public class chloe86 {
	public static void main(String[] args) {
		// 1. Load Driver -> Connector => 證明你的jar load 進來是正確的 => 新版的Java 這幾段可以不用做 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  // java.lang Class Class<T> => 載入驅動程式 => 用來驗證驅動程式是對的
			//Class.forName("com.mysql.jdbc.Driver"); => 舊版
		} catch (ClassNotFoundException e) {
			System.out.println(e.toString());
		}
		
		// 2. Create Connection
		try {
			Connection conn = DriverManager.getConnection(  // 拿到 Connection 的物件實體了
					"jdbc:mysql://localhost:3307/iii?user=root&password=root");
			// 3. SQL statement => 取得SQL句法的物件實體
			Statement stmt = conn.createStatement(); 
			// 4. execute SQL statement
			// stmt.execute("INSERT INTO cust (name,tel,birthday) VALUES ('brad1','123','1999-01-02')");
			int n = stmt.executeUpdate(
					"INSERT INTO cust (name,tel,birthday) " + 
							"VALUES ('brad1','123','1999-01-02')," +
							" ('brad2','123','1999-01-02')," +
							" ('brad3','123','1999-01-02')"
					);
			System.out.println(n);
			conn.close();
			System.out.println("OK1");
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
	}

}
