package Generator;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

// 之前在 Mediatek 的 BBS 聊天程式 => 就是這樣可以傳訊息給人
// UDP => 若無人接收就丟棄

public class chloe78 {
	public static void main(String[] args) {
//		byte[] buf = "擬速誰".getBytes(StandardCharsets.UTF_8);
		byte[] buf = "Ram Ram Chloe".getBytes();  // 總長度包含 空格, 而不是換行符號
		
		String mesg2 = new String(buf, 0, buf.length, 
				StandardCharsets.UTF_8);
		byte[] buf2 = mesg2.getBytes();
		
		try {
			// 發送封包出去
			DatagramSocket socket = new DatagramSocket();
			DatagramPacket packet = new DatagramPacket(buf, buf.length, 
					InetAddress.getByName("10.0.104.148"), 8888);  // 資策會wifi的 ip: => Terminal => ifconfig => eth0: => inet 10.0.104.148
//					InetAddress.getByName("127.0.0.1"), 8889);
			socket.send(packet);
			socket.close();
			
			System.out.println("Send OK");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		
	}

}
