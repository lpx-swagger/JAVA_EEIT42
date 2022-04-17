package Generator;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import myClass.BikeV2;
import myClass.StudentV3;


/*
 * 設計遊戲，利用存成資料庫，下次打開，可以回到上一次的地方 => Pokemon GBA
 * JAVA 只是負責拿出來呈現，盡量在 sql 做資料，別讓JAVA負荷太多
*/

public class chloe95 {
	public static void main(String[] args) {
		StudentV3 s1 = new StudentV3("chloe", 70, 43, 56);
		BikeV2 b1 = s1.getBike(); b1.upSpeed(); b1.upSpeed(); b1.upSpeed();
		System.out.println(s1 + ":" + s1.score() + ":" + s1.avg() + ":" + s1.getBike().getSpeed());
		
		// 上傳到資料庫
		Properties prop = new Properties();
		prop.put("user", "root");prop.put("password", "root");
		
		// 先想你會的?怎麼寫 我可以先知道 a. => 再來想 b. 怎麼寫
		String sql = "UPDATE member SET student = ? WHERE id = ?";
			
		try(Connection conn = DriverManager.getConnection(
			"jdbc:mysql://localhost:3307/iii", prop)) {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// a.
			pstmt.setInt(2, 16);

			// b.
			// 先把資料丟在memory
			// 先 write output object (s1) => 再進行串接 => 到 oout.writeObject(s1) 來
			// => byte[] s1Ary 陣列 拿到後 存在 memory
			// 除錯 System.out.println(s1Ary.length); 看看 byte[] 有沒有存在
			// 可以正式進入 pstmt.setBinaryDtream(1,???) => ???: s1 序列化的資料 => ??? = new ByteArrayInputStream(s1Ary)
			ByteArrayOutputStream bao = new ByteArrayOutputStream();
			ObjectOutputStream oout = new ObjectOutputStream(bao);
			oout.writeObject(s1);
			byte[] s1Ary = bao.toByteArray();
			System.out.println(s1Ary.length);

			pstmt.setBinaryStream(1, new ByteArrayInputStream(s1Ary));

			int n = pstmt.executeUpdate();
			if(n > 0) {
				System.out.println("Update Success");
			} else {
				System.out.println("Update Failure");
			}
		}catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
