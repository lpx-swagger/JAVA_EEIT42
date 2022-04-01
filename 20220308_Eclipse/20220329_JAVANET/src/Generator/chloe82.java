package Generator;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

// TCP 接收端 (Input)
// Brad receiver 等我傳圖檔給他
// UDP 不適合傳圖檔
// 此程式需手動中斷，你可以設 只要來自 ip: 10.0.104 就中斷 

public class chloe82 {
	public static void main(String[] args) {		
		try (ServerSocket server = new ServerSocket(7777)){
			while(true) {
				Socket socket = server.accept();
				System.out.println(socket.getInetAddress().getHostAddress());
				if (socket == null) break;  // 騙系統該中斷

				new Thread() {
					public void run() {
						try {
							String host = socket.getInetAddress().getHostAddress();
							FileOutputStream fout = new FileOutputStream("dir1/" + host + ".jpg");

							BufferedInputStream bin = 
									new BufferedInputStream(socket.getInputStream());  // 拿到socket後，就可以input進來
							byte[] buf = new byte[4096];
							int len;
							while ((len = bin.read(buf)) != -1) {
								fout.write(buf,0,len);
							}
							bin.close();

							fout.flush();
							fout.close();
						}catch(Exception e) {
							System.out.println(e.toString());
						}

					};
				}.start();
			}
			
			server.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}

}
