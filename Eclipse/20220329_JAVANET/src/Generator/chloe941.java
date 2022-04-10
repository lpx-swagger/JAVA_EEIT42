package Generator;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

// JAVA 可以做many不同stream的變化，其他語言沒有做得這麼細膩

public class chloe941 {
	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", "root"); 
		prop.put("password", "root");
		String sql = "SELECT * FROM member WHERE id = ?";
		
		try(Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3307/iii", prop)){  // 如果要做多個庫，iii就省略
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 16);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				Blob blob = rs.getBlob("icon");  // getBlob() 裡面要放欄位名稱，若欄位名稱有做AS 就要以AS的名稱為主

				// 老師示範ball.png先存下來點開來看看, 因為不是要做圖形顯示；若要做圖形，利用BufferedInput + IOImg 就可以看
				FileOutputStream fout =
					new FileOutputStream("dir1/icon.png");

				// Output 之前先看要如何input進去才可以寫出來，利用 blob.get 來看如何input => 一般用BufferedInputStream
				BufferedInputStream bin = 
					new BufferedInputStream(blob.getBinaryStream());
				byte[] buf = new byte[4*1024]; int len;  // 用byte較順暢
				while ((len = bin.read(buf)) != -1) {
					fout.write(buf, 0, len);
				}
				bin.close();
				fout.flush();
				fout.close();
				System.out.println("Fetch OK");
			}else {
				System.out.println("data not exist");
			}

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}
