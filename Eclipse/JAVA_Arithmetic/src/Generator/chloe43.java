package Generator;

//TODO 觀念還沒釐清

public class chloe43 {
	public static void main(String[] args) {
		// own class method => static
		chloe431 obj1 = new chloe431();
		obj1.m1((byte)1.0);
		obj1.m1((byte)1);
		obj1.m1(1.2F);
		//obj1.m1((byte)1, (byte)2);
		//obj1.m1(new chloe4311());
		obj1.m1((chloe4312) new chloe4311());  // 強制轉型成 chloe4312
		//obj1.m1((chloe4312)(chloe4311)new chloe4313()); /* 沒有直系關係 => 不存在「強制轉型」這件事情，
		//骨子裏是什麼就是什麼 法拉利可以轉成法拉利，但不可以是 Toyota*/
	}
}

class chloe431 { // 類別物件
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
	//void m1(chloe4311 a) {System.out.println("chloe4311");}
	void m1(chloe4312 a) {System.out.println("chloe4312");}
}

class chloe4311 {}
class chloe4312 extends chloe4311 {}
class chloe4313 extends chloe4311{}
class chloe43121 extends chloe4312 {}

/* chloe43
 11
  |__12
  |	  |__121
  |
  |__13
  
 */
 