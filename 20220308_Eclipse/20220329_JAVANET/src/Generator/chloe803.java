package Generator;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class chloe803 {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(9996);
			Socket socket = server.accept();
			
			
//			InputStream in = socket.getInputStream();
			
			BufferedReader reader = 
					new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			String line;
			while( (line = reader.readLine()) != null) {  // 一次一列，若遇到 null 就沒資料
				System.out.println(line);
			}
			
			reader.close();
			
			server.close();
			
			System.out.println("sever ok");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}
