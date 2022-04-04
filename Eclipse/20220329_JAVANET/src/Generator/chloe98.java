package Generator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import myClass.BCrypt;

// 伺服器 進階(自修)
	// 差異式備份
	// 權限 => 庫，表，欄位

public class chloe98 {
	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", "root"); prop.put("password", "root");
		
		String sql = "SELECT * FROM member";
		try (Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost/iii", prop)){
			
			PreparedStatement pstmt = conn.prepareStatement(
					sql,
					ResultSet.TYPE_FORWARD_ONLY,  // 效能較好 
					ResultSet.CONCUR_UPDATABLE
					);
		
			ResultSet rs = pstmt.executeQuery();
			
			rs.next();  // 指向目前的第一筆資料
			System.out.println(rs.getString("account"));
			
			rs.updateString("account", "newbrad2");
			rs.updateString("realname", "brad2");
			rs.updateRow();  // TODO 剛剛只是在記憶題做，這行再整個做出來 ??
			System.out.println(rs.getString("account"));


			// 再繼續往下增加
			rs.next();
			System.out.println(rs.getString("account"));
			rs.deleteRow();
			
			// before first  // TODO 再砍下一筆?
			System.out.println(rs.getString("account"));

			rs.moveToInsertRow();  // 指標先指到準備要move的row
			rs.updateString("account", "iii");
			rs.updateString("realname", "III");
			rs.updateString("passwd", 
				BCrypt.hashpw("123456", BCrypt.gensalt()));
			rs.insertRow();
			
			System.out.println(rs.getString("account"));
			
			
		}catch(Exception e) {
			System.out.println(e.toString());
		}

			// *** 每做完一個動作，指標在哪要知道
		
	}

}
