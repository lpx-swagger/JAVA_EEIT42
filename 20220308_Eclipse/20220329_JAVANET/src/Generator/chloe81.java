package Generator;

import java.io.BufferedOutputStream;
import java.net.InetAddress;
import java.net.Socket;

// chloe81 & chloe82
// TCP 發送端 (Output)
// 網頁 http 也是一種 TCP
// https 的 s => ssl
// 自己的電腦有開哪些 port number


public class chloe81 {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket(
					InetAddress.getByName("10.0.104.148"), 7777);
			
			BufferedOutputStream bout = new BufferedOutputStream(
					socket.getOutputStream());
			bout.write("Hello, Brad".getBytes());
			bout.close();
			
			socket.close();
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}
