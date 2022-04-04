package Generator;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

//chloe801 & chloe802
// TCP server 等待clinet 傳送資料過來

public class chloe802 {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(9997);
			System.out.println("BEFORE");
			Socket socket = server.accept();
			System.out.println("AFTER");
			server.close();
			System.out.println("SEVER OK");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}
