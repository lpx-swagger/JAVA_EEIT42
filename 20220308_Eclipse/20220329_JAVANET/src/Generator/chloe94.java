package Generator;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

//檔案上傳到資料庫 Upload => 前端班才會上到 php?

public class chloe94 {
	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", "root"); prop.put("password", "root");
		String sql = "UPDATE member SET icon = ? WHERE id = ?";
		
		
		
		try(Connection conn = DriverManager.getConnection(
//					"jdbc:mysql://127.0.0.1", prop)){  // 127.0.0.1 本站迴路 ip, 也可用localhost(似別名，也可以叫brad) => 釣魚程式，把別名換掉
					"jdbc:mysql://localhost:3306/iii", prop)){
				PreparedStatement pstmt = conn.prepareStatement(sql);
			
				File file = new File("dir1/ball.png");
				
				if(file.length() <= 60*1000 ) {
					pstmt.setBlob(1, new FileInputStream(file));  // 這裡也可以用setBinary, 老師為了示範多種應用
					pstmt.setInt(2, 16);
					int n = pstmt.executeUpdate();  // 在乎 所影響的列數
					
					if (n > 0) {
						System.out.println("Update Success");
					}else {
						System.out.println("Update Failure");
					}
					
				} else {
					System.out.println("File too big");
				}
				
			} catch(Exception e) {
				System.out.println(e.toString());
			}
				
		}
		
}
