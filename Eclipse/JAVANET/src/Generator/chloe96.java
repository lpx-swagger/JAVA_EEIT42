package Generator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

// setAutoCommit => 交易平衡，rollback

public class chloe96 {
	public static void main(String[] args) {
		// 連線到sql
		Properties prop = new Properties();
		prop.put("user", "root");prop.put("password", "root");
		
		try(Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3307/iii", prop)) {
			String sql1 = "UPDATE member SET money = money - ? WHERE id = ?";
			String sql2 = "UPDATE member SET money = money + ? WHERE id = ?";
		
			// 我規定了，你才commit ，先不要 AutoCommit, 我決定可以你才去做
			conn.setAutoCommit(false);
		
			// person1 多10，person2 少10
		
			PreparedStatement pstmt1 = conn.prepareStatement(sql1);
			pstmt1.setInt(1, 10);
			pstmt1.setInt(2, 2);
			int n1 = pstmt1.executeUpdate();
			
			PreparedStatement pstmt2 = conn.prepareStatement(sql2);
			pstmt2.setInt(1, 10);
			pstmt2.setInt(2, 17);
			// 若資料有異動才做update
			int n2 = pstmt2.executeUpdate();

			// 我剛剛沒有commit 的在符合這裡的規定才做
			if(n1 > 0 && n2 > 0) {
				conn.commit();
				System.out.println("Finish");
			} else {
				System.out.println("Ooop!");
			}
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}

}
