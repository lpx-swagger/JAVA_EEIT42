package Generator;


public class chloe48 {
	public static void main(String[] args) {
		chloe481 obj1 = new chloe482();
		chloe481 obj2 = new chloe483(); // 我需一個認證工程師(chloe481)，哪個類別都沒關係，只要符合chloe483規格的物件實體都可以
//		chloe481 obj3 = new chloe482(); // interface 無法用new處理，後面會教
		test(obj1);
		test(obj2);
		chloe484 obj4 = new chloe483();
		obj4.m5();
	}
	
	static void test(chloe481 obj) {
		obj.m1();
		obj.m2();
	}
}

interface chloe481 {  // 即使沒有寫 public 他就是 public
	void m1();
	void m2();
}

// Method 1:
///* interface裡的method只要有其中一個沒有做到 => 你需要做又沒做 => abstract class */
//abstract class chloe482 implements chloe481 { // 你需要做又沒做 => abstract
//	public void m1() {};
//	//void m2() {};  => 沒有
//	//void m1(int a) {} => 你自訂，與規格無關
//	public void m2() {};
//}
//// abstract 存在 inheriented 關係
//// abstract 可以讓我想用什麼拿來用就好，其餘的可以不用拿
//// abstract 的意義：創造子類別的多型

// Method 2:
class chloe482 implements chloe481 {  // 方法若少了一個 規格要求的方法，你就得用abstract 來寫
	//void m1(); => 規格要你public 實作出來 所以前面要有public
	public void m1() {System.out.println("Brad482:m1()");}
	public void m2() {System.out.println("Brad482:m2()");}
	void m3() {}
}

class chloe483 implements chloe481, chloe484 {
	public void m1() {System.out.println("Brad483:m1()");}
	public void m2() {System.out.println("Brad483:m2()");}
	void m4() {}
	public void m5() {System.out.println("Brad483:m5()");}
}

interface chloe484 {
//	public void m5(); => public 也可以不寫
	void m5();
}

interface chloe485 extends chloe481, chloe484 {
	// extends => 規格又訂更多了
}

