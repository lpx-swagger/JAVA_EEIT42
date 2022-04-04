package Generator;

public class chloe39 {
	public static void main(String[] args) {
		String s1 = "Brad";
		String s2 = new String();
		byte[] b1 = {97,98,99,100,101,102};
//		byte[] b2 = new byte[] {1,2,3,4} ; // 給出指定的初始化 == byte[] b2 = {1,2,3,4}
//		byte[] b3;
//		b3 = {1,2,3,4};
		String s3 = new String(b1);
		String s4 = new String(b1, 2,3);
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
 	}
}
