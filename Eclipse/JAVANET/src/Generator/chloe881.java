package Generator;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Properties;

import org.json.JSONArray;
import org.json.JSONObject;

// 增！
// stmt.execute() => Boolean


public class chloe881 {
	public static PreparedStatement pstmt;
	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		
		// 1. 抓JSON 回來
		try {
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3307/iii", prop);
			
			// 3. SQL statement
			Statement stmt = conn.createStatement();
			boolean isQuery = stmt.execute("INSERT INTO foods (name,addr,tel) VALUES ('chloe','123','1996-01-03')");
			System.out.println(isQuery?"Query":"Update");  // INSERT增, DELETE刪, UPDATE修 => 回傳的值都會是Update
			
//			boolean isQuery = stmt.execute("SELECT * FROM cust");
//			System.out.println(isQuery?"Query":"Update");  // 查！ => 回傳 Query
			
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		
		// 1. 抓 json 回來
		fetchJSON();
		// 2. parse json
		// 3. insert into
		System.out.println("OK");
	}
	
	private static void fetchJSON() {
		try {
			URL url = new URL("https://data.coa.gov.tw/Service/OpenData/ODwsv/ODwsvTravelFood.aspx");
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			
			BufferedReader reader = 
				new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line; StringBuffer sb = new StringBuffer();
			while ( (line = reader.readLine()) != null) {
				sb.append(line);
			}
			reader.close();
			conn.disconnect();
			
			parseJSON(sb.toString());
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	private static void parseJSON(String json) {
		try {
			JSONArray root = new JSONArray(json);
			for (int i=0; i<root.length(); i++) {
				JSONObject row = root.getJSONObject(i);
				String name = row.getString("Name");
				String addr = row.getString("Address");
				String tel = row.getString("Tel");
				
				insertData(name, addr, tel);
				
			}
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}
	
	private static void insertData(String name, String addr, String tel) {
		try {
			pstmt.setString(1, name);
			pstmt.setString(2, addr);
			pstmt.setString(3, tel);
			
			// 4. execute SQL statement
			pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}

}
