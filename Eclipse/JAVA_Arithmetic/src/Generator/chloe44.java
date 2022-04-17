package Generator;

//TODO 觀念還沒釐清

public class chloe44 {
	public static void main(String[] args) {
		chloe441 obj1 = new chloe441();
		chloe4412 obj2 = new chloe4412();
		chloe441 obj3 = new chloe4412();
		//chloe4412 obj4 = (chloe4412)new chloe441();
		obj1.m2(1);
		obj2.m2(1);
		obj3.m2(1);
		chloe441 obj5 = obj2;
		System.out.println(obj5 == obj2);
		// 多型 is-a, has-a
	}
}

class chloe441 {
	void m1() {System.out.println("Brad441:m1()");}
	void m2(int a) {System.out.println("Brad441:m2(int)");}
}

class chloe4412 extends chloe441 {
	void m2() {
		// super => 若是 constructor 就是第一行
		System.out.println("chloe4412:m2()");
		super.m2((byte)1);
	}
	
	public void m2(int a) {
		System.out.println("Brad4412:m2(int)");
	}
	
	// 爸爸沒有定義 return, 子也不行 return; 基本型別上，爸爸是 byte, 子不能傳回 int(非byte型別)
	void m3() {System.out.println("chloe4512:m3()");}
}

