package Generator;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

// UDP

public class chloe79 {
	public static void main(String[] args) {
		byte[] buf = new byte[4096];   // 2^12 要給 > 你輸入的string，一個中文字有 3 byte
			while (true) {
				try {
					DatagramSocket socket = new DatagramSocket(8888);
					DatagramPacket packet = new DatagramPacket(buf, buf.length); // receiver 不需要 address
					
					System.out.println("before");
					socket.receive(packet);
					System.out.println("after");
					socket.close();
					
					String who = packet.getAddress().getHostAddress();
					byte[] rec = packet.getData();
					System.out.println("len: " + rec.length + "; " + packet.getLength());
					int len = packet.getLength();
					String mesg = new String(rec, 0, len, StandardCharsets.UTF_8);
					System.out.println(who + " : " + mesg);
					if (mesg.equals("bye")) {
						break;
					}
				} catch (Exception e) {
					System.out.println(e.toString());
				}
			}
	}

}
