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
		prop.put("user", "root"); 
		prop.put("password", "root");
		String sql = "UPDATE member SET icon = ? WHERE id = ?";
		
		try(Connection conn = DriverManager.getConnection(
//					"jdbc:mysql://127.0.0.1", prop)){  // 127.0.0.1 本機迴路位置 ip (DNS 觀念，你去問他，他回報給你ip,你再用ip 去做你想做的事情), 也可用 "localhost" (只是一個名稱，似別名，也可以叫brad) => 釣魚程式，把別名換掉 => 127.0.0.1 = localhost
					"jdbc:mysql://localhost:3307/iii", prop)){
				PreparedStatement pstmt = conn.prepareStatement(sql);
			
				File file = new File("dir1/ball.png");
				
				if(file.length() <= 60*1000 ) {  // Blob 最大大概 64k => 64*1000
					pstmt.setBlob(1, new FileInputStream(file));  // 第1個?, 這裡也可以用setBinary, 老師為了示範多種應用所以使用setBlob
					pstmt.setInt(2, 16);  // 第2個?
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
