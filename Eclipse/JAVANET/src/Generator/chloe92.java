package Generator;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;


import myClass.BCrypt;
import myClass.BikeV2;

// 3人密碼都設123456，但是顯示出來不一樣 => hash

public class chloe92 {
	public static void main(String[] args) {
		// 2. Create Connection
		try {
			Properties prop = new Properties();
			prop.put("user", "root");
			prop.put("password", "root");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3307/iii", prop);
			
			// 寫記憶體裡面，再轉 byte 出來
			BikeV2 b1 = new BikeV2();  // 物件 Serializable
			ByteArrayOutputStream bao = new ByteArrayOutputStream();
			ObjectOutputStream oout = new ObjectOutputStream(bao);
			oout.writeObject(b1);
			
			ObjectInputStream oin = new ObjectInputStream(
					new ByteArrayInputStream(bao.toByteArray()));
			
			FileInputStream fin = new FileInputStream("dir1/ball.png");
			
			String account = "chloe";
			String passwd = "123456";
			String realname = "呂";
			
			// 3. SQL statement => 使用 PreparedStatement 和 ? 預存的方式來防止隱碼攻擊(SQL Injection)
			PreparedStatement pstmt = conn.prepareStatement(
					"INSERT INTO member (account, passwd, realname, obj)"
					+ " VALUES (?,?,?,?)");
			pstmt.setString(1, account);
			pstmt.setString(2, BCrypt.hashpw(passwd, BCrypt.gensalt()));
			pstmt.setString(3, realname);
			pstmt.setBinaryStream(4, oin);
			
			// 4. execute SQL statement
			pstmt.executeUpdate();
			
			PreparedStatement pstmt2 = conn.prepareStatement(
					"SELECT * FROM member WHERE id = 9");
			
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				InputStream ii = rs.getBinaryStream("obj");
				ObjectInputStream tt = new ObjectInputStream(ii);
//				Object obj = tt.readObject();
//				Bike b2 = (Bike)obj;
			}else {
				System.out.println("XX");
			}
			
			conn.close();
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}

}