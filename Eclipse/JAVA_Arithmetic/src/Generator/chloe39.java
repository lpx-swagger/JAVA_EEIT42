package Generator;

public class chloe39 {
	public static void main(String[] args) {
		System.out.println("Hello, World".codePointAt(4));
		System.out.println("Hello, World".charAt(4));
		System.out.println("-----");
		String s1 = "Brad";
		String s2 = "Brad";
		String s3 = new String("Brad");
		String s4 = new String("Brad");
		System.out.println(s1 == s2);
		System.out.println(s1 == s3);
		System.out.println(s3 == s4);
		System.out.println(s1.equals(s2));
		
		System.out.println("-----");
		Object obj1 = new Object();
		Object obj2 = new Object();
		Object obj3 = obj2;
		System.out.println(obj2.equals(obj3));
		
		System.out.println("---");
		String s5 = s1.concat("Concat");
		String s6 = "0123456789";
		String s7 = "CHLOE";
		System.out.println(s1);
		System.out.println(s5);
		System.out.println(s6.substring(1,7));
		System.out.println(s6.replace('8', '7'));
		System.out.println(s7.toLowerCase());
	}

}
