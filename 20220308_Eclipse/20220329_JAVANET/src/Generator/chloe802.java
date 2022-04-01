package Generator;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

// TCP server 等待clinet 傳送資料過來

public class chloe802 {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(9997);
			System.out.println("BEFORE");
			Socket socket = server.accept();
			System.out.println("AFTER");
			server.close();
			System.out.println("sever OK");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}
