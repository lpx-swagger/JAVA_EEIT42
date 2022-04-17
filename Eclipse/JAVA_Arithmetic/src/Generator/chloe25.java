package Generator;

// from: EEIT36 Brad34
// abstract 列子 => 聯絡人

public class chloe25 {
	public static void main(String[] args) {
		//Brad341 obj1 = new Brad341();
		chloe341 obj1 = new chloe342();
		chloe342 obj2 = new chloe342();
	}
}

abstract class chloe341 {  // abstract: 各自表述
	void m1() {System.out.println("Brad341:m1()");}
	abstract void m2();
}

// Method 1:
//abstract class Brad342 extends Brad341 {
//	
//}

// Method 2:
class chloe342 extends chloe341 {
	void m2() {System.out.println("Brad342:m2()");} // 有 {} 就是有實作
}

class chloe343 extends chloe341 {
	void m2() {System.out.println("Brad343:m2()");}	
}

