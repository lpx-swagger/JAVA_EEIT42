package Generator;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class chloe861 {
	public static void main(String[] args) {
		// 1. Load Driver -> Connector => 證明你的jar load 進來是正確的 => 新版的 mysql 這幾行可以不用做 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Class.forName("com.mysql.jdbc.Driver"); => 舊版
		} catch (ClassNotFoundException e) {
			System.out.println(e.toString());
		}
		
		// 2. Create Connection
				try {
					Connection conn = DriverManager.getConnection(
							"jdbc:mysql://localhost:8888/iii", "root", "root");
					// 3. SQL statement => 物件實體
					Statement stmt = conn.createStatement(); 
					// 4. execute SQL statement
					int n = stmt.executeUpdate(
						"INSERT INTO cust (name,tel,birthday) " + 
							"VALUES ('brad1','123','1999-01-02')," +
							" ('brad2','123','1999-01-02')," +
							" ('brad3','123','1999-01-02')"
								);
//					stmt.execute("INSERT INTO cust (name,tel,birthday) VALUES ('brad1','123','1999-01-02')");
					System.out.println(n);
					conn.close();
					System.out.println("OK2");
				} catch (SQLException e) {
					System.out.println(e.toString());
				}
		
	}

}
