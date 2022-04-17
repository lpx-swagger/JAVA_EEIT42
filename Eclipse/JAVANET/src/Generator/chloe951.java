package Generator;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import myClass.StudentV3;


public class chloe951 {
	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", "root");prop.put("password", "root");
		
		String sql = "SELECT * FROM member WHERE id = ?";
		
		try(Connection conn = DriverManager.getConnection(
			"jdbc:mysql://localhost:3307/iii", prop)) {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 16);
			ResultSet rs = pstmt.executeQuery();
		
			if(rs.next()) {
				InputStream in = rs.getBinaryStream("student");  // 不再串接，直接來, 拿到串流
				ObjectInputStream oin = new ObjectInputStream(in);  // 解序列化，要變成物件才去解序列化 => 才能看得到
				Object obj = oin.readObject();
				oin.close();  // 關閉串流

				// 這樣串來串去都在memory 騰出一個空間，並不是產出一個物件出來
				
				if(obj instanceof StudentV3) {
					// 既然是Student, 強制轉型 “回來”？
					System.out.println("I am student");
					StudentV3 s1 = (StudentV3)obj;
					System.out.println(s1);
					System.out.println(s1.score());
					System.out.println(s1.avg());
					System.out.println(s1.getBike().getSpeed());
				}
				
			}else {
				System.out.println("data not exist");
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}
