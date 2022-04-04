package Generator;

import java.io.BufferedOutputStream;
import java.net.InetAddress;
import java.net.Socket;

// chloe801 & chloe802
// TCP 連線動作 to chloe802.java
//確認 我開的port 有無被佔用
	// 顯示結果：java.net.ConnectException: Connection refused => 表示沒有人使用(櫃檯沒有人在那服務) port: 9997，有人在用的話就會顯示 client OK

public class chloe801 {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9997);

			socket.close();
			System.out.println("CLIENT OK");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}
