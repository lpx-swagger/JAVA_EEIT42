package Generator;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

// read line 使用 String[] 來寫

public class chloe882 {

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		String sqlDelAllString = "DELETE FROM mask";
		String sql = "INSERT INTO mask (hid,hname,haddr,htel,anum,cnum,dtime) VALUES (?,?,?,?,?,?,?)";
		
		try (Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3307/iii", prop)) {
			connection.createStatement().executeUpdate(sqlDelAllString);
			
			PreparedStatement pstmt = connection.prepareStatement(sql);

			URL url = new URL("https://data.nhi.gov.tw/resource/mask/maskdata.csv");  // 2022.4.10 空資料
			URLConnection urlConn =  url.openConnection();
			urlConn.connect();
			
			BufferedInputStream bin = new BufferedInputStream(urlConn.getInputStream());
			BufferedReader reader = new BufferedReader(new InputStreamReader(bin));
			
			// 跑第一次發現 row 1 不應該會進去，因為 我資料庫的 id => INT, 而不是 VARCHAR
				// java.sql.SQLException: Incorrect integer value: '成人口罩剩餘數' for column 'anum' at row 1
			reader.readLine();  // 先把第一列先讀進去，不跑迴圈  
			
			String line;
			while ( (line = reader.readLine()) != null) {
				String[] row = line.split(",");
				pstmt.setString(1, row[0]);
				pstmt.setString(2, row[1]);
				pstmt.setString(3, row[2]);
				pstmt.setString(4, row[3]);
				pstmt.setString(5, row[4]);
				pstmt.setString(6, row[5]);
				pstmt.setString(7, row[6]);
				pstmt.executeUpdate();
			}
			bin.close();
			
			System.out.println("Scuess");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		// 醫事機構代碼,醫事機構名稱,醫事機構地址,醫事機構電話,成人口罩剩餘數,兒童口罩剩餘數,來源資料時間
		// 0145080011,衛生福利部花蓮醫院豐濱原住民分院,花蓮縣豐濱鄉豐濱村光豐路４１號,8358141,2450,940,2021/10/12 15:20:24
	}

}
