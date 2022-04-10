package MyClass;

public class MyCalcV1 {
	
	private int a, b;
	public MyCalcV1() {
		a = (int)(Math.random()*49+1);
		b = 0;
	}
	
	public MyCalcV1(int a, int b) {
//	public MyCalcV1(int aa, int bb) {
		this.a = a; // this 上面就是 super
//		aa = a;
		this.b = b;
	}
	
	public int minus() {
		return a - b;
	}
	
	public int minus(boolean isReverse) {
		if (isReverse) {
			return a-b;
		} else {
			return a+b;
		}
	}
	
	public int multiple() {
		return a * b;
	}
	public int div() {
		return a / b;
	}
	public int getA() {
		return a;
	}
	public int getB() {
		return b;
	}
	
}
