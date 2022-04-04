package Generator;

public class chloe44 {

	public static void main(String[] args) {
		// own class method => static
		chloe441 obj1 = new chloe441();
		obj1.m1((byte)1.0);
		obj1.m1(1.2F);
		//obj1.m1((byte)1, (byte)2);
		//obj1.m1(new chloe4411());
		obj1.m1((chloe4412) new chloe4411());  // 強制轉型成 chloe4412
		//obj1.m1((chloe4412)(chloe4411)new chloe4413()); /* 沒有直系關係 => 不存在「強制轉型」這件事情，
		//骨子裏是什麼就是什麼 法拉利可以轉成法拉利，但不可以是 Toyota*/
	}
}

class chloe441 { // 類別物件
	// 以下一樣都叫overload, no matter public or private
	void m1() {System.out.println("m1()");}
	//void m1(byte a) {System.out.println("m1(byte)");}
	void m1(int a) {System.out.println("m1(int)");}
	//int m1(int a) {System.out.println("m1(int)"); return m1;}
	void m1(float a) {System.out.println("m1(float)");}
	void m1(double a) {System.out.println("m1(double)");}
	void m1(byte a, int b) {System.out.println("byte(a), int(b)");}
	void m1(int a, byte b) {System.out.println("int(a), byte(b)");}
	// charactor & short 不存在 自動轉型
	//void m1(chloe4411 a) {System.out.println("chloe4411");}
	void m1(chloe4412 a) {System.out.println("chloe4412");}
}

class chloe4411 {}
class chloe4412 extends chloe4411 {}
class chloe4413 extends chloe4411{}
class chloe44121 extends chloe4412 {}

/* chloe44
 11
  |__12
  |	  |__121
  |
  |__13
  
 */
 