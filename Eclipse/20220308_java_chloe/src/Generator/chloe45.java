package Generator;

public class chloe45 {

	public static void main(String[] args) {
		chloe451 obj1 = new chloe451();
		chloe4512 obj2 = new chloe4512();
		chloe451 obj3 = new chloe4512();
		chloe4512 obj4 = (chloe4512)new chloe451();
		chloe obj5 = obj2;
		// 多型 is-a, has-a
		
	}

}

class chloe451 {
	void m1() {System.out.println("451:m1()");}
	void m2() {System.out.println("451:m2()");}
}

class chloe4512 extends chloe451 {
	void m2() {
		// super => 若是 constructor 就是第一行
		System.out.println("chloe4512:m2()");
		super.m2((byte)1);
	}
	// 爸爸沒有定義 return, 子也不行 return; 基本型別上，爸爸是 byte, 子不能傳回 int(非byte型別)
	void m3() {System.out.println("chloe4512:m3()");}
}

