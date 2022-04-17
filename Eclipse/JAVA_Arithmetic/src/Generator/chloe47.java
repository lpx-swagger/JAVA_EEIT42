package Generator;

public class chloe47 {
	public static void main(String[] args) {
		//Brad471 obj1 = new Brad471();
		chloe472 obj2 = new chloe472();
		obj2.m1(); obj2.m2();obj2.m3();
		chloe471 obj1 = new chloe472();
		obj1.m2();
	}	
}

abstract class chloe471 {
	chloe471(){System.out.println("Brad471()");}
	void m1() {System.out.println("Brad471:m1()");}
	abstract void m2();
}

class chloe472 extends chloe471 {
	chloe472(){System.out.println("Brad472()");}
	void m2() {System.out.println("Brad472:m2()");}
	void m3() {}
}