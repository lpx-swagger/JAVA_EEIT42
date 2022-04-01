package Generator;

import java.net.InetAddress;
import java.net.UnknownHostException;

// ip => 42億多 => 美國擁有最多ip => iv4 => 不夠使用 => 才延伸出 iv6
// DNS: Domain Name System => 掉魚程式，掉出你的帳號密碼
// DNS => 問路而已，重要的是後面的程序 => 速度要快
// 192.168.3.4 => 192.268 => 找不到 => 最多 0~255
public class chloe77 {
	public static void main(String[] args) {
		try {
			
			// 通常大公司測出來的ip address 才會不一樣 => DNS 輪尋 => 分流
//			ip = InetAddress.getByName("www.hinet.net");
			
			// 多少個分流
			InetAddress[] ips = InetAddress.getAllByName("www.microsoft.com");  // 大公司 測出來ip都一樣耶？！ => Brad: 可以他們只做內部分流而已
			for(InetAddress ip : ips) {
				System.out.println(ip.getHostAddress());
			}
			
		} catch (UnknownHostException e) {
			System.out.println(e.toString());
		}  
		
	}

}
