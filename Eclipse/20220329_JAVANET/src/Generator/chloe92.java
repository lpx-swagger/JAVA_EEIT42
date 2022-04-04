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

// 3人密碼都設123456，但是顯示出來不一樣
// TODO
public class chloe92 {
	public static void main(String[] args) {
		// 2. Create Connection
		try {
			Properties prop = new Properties();
			prop.put("user", "root");
			prop.put("password", "root");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/iii", prop);
			
			BikeV2 b1 = new BikeV2();
			ByteArrayOutputStream bao = new ByteArrayOutputStream();
			ObjectOutputStream oout = new ObjectOutputStream(bao);
			oout.writeObject(b1);
			
			ObjectInputStream oin = new ObjectInputStream(
					new ByteArrayInputStream(bao.toByteArray()));
			
			FileInputStream fin = new FileInputStream("dir1/ball.png");
			String account = "chloe";
			String passwd = "123456";
			String realname = "呂";
			PreparedStatement pstmt = conn.prepareStatement(
					"INSERT INTO member (account, passwd, realname)"
					+ " VALUES (?,?,?)");
			pstmt.setString(1, account);
			pstmt.setString(2, BCrypt.hashpw(passwd, BCrypt.gensalt()));
			pstmt.setString(3, realname);
			pstmt.setBinaryStream(4, oin);
			
			// 4. execute SQL statement
			pstmt.executeUpdate();
			
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String addr = rs.getString("addr");
				String tel = rs.getString("tel");
				System.out.println(id + ":" + name + ":" + addr + ":" + tel);
			}
			
			conn.close();
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}

}