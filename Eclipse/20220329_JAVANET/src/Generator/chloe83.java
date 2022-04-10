package Generator;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.InetAddress;
import java.net.Socket;

// 傳送一張圖給 Brad 

public class chloe83 {
	public static void main(String[] args) {
		try {
			File source = new File("dir1/coffee1.jpg");  // 檔案一次來很多， 用 File 寫比較快
			byte[] buf = new byte[(int)source.length()];
			FileInputStream fin = new FileInputStream(source);
			fin.read(buf);
			fin.close();
			
			Socket socket = new Socket(
					InetAddress.getByName("10.0.104.154"), 7777);
			
			BufferedOutputStream bout = new BufferedOutputStream(
					socket.getOutputStream());
			bout.write(buf);
			bout.flush();
			bout.close();
			
			socket.close();
			System.out.println("Client OK");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}
