package Generator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import myClass.BCrypt;

// Properties vs. hashMap

// 鳥哥私房菜 伺服器 進階(自修)
	// 差異式備份 => 伺服器上自動備份 => 離峰時間 Taiwan 4a.m. => crontab
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
					ResultSet.TYPE_FORWARD_ONLY,  // 指標移動相關，效能較好 
					ResultSet.CONCUR_UPDATABLE   // 同步
					);
		
			ResultSet rs = pstmt.executeQuery();
			
			rs.next();  // 通常指向目前的第一筆資料 brad
			System.out.println(rs.getString("account"));
			
			rs.updateString("account", "newbrad2");  // 只是在記憶體裡面做
			rs.updateString("realname", "brad2");  // 只是在記憶體裡面做
			rs.updateRow();  // 這行再整個做出來
			System.out.println(rs.getString("account"));

			// 再繼續往下增加筆數
			rs.next();
			System.out.println(rs.getString("account"));
			rs.deleteRow();
			
			// 查詢指標目前到哪了
			System.out.println(rs.getString("account"));

			rs.moveToInsertRow();  // 指標先指到準備要move的row
			rs.updateString("account", "iii");
			rs.updateString("realname", "III");
			rs.updateString("passwd", 
				BCrypt.hashpw("123456", BCrypt.gensalt()));
			rs.insertRow();
			
			// 查詢指標目前到哪了
			System.out.println(rs.getString("account"));
			
			
		}catch(Exception e) {
			System.out.println(e.toString());
		}

			// *** 每做完一個動作，指標在哪要知道
		
	}

}
