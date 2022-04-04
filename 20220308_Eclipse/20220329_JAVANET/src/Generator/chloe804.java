package Generator;

import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;


// chloe803 & chloe804
// 使用此code的前提是 client & server 接收端知道發送端要給 文字資料 才這樣寫
	// 在不知道的情形下，不要用 InputStream + OutputStream

public class chloe804 {
	public static void main(String[] args) {
String mesg = "Hello, 資策會\n愚\n人\n節"; 
		
		try {
			Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9996);
			
			OutputStream out = socket.getOutputStream();
			out.write(mesg.getBytes());
			out.flush();
			out.close();
			
			socket.close();
			System.out.println("client ok");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}
