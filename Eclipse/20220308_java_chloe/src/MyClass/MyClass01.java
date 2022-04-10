package MyClass;

public class MyClass01 {
	public int var1;
	public String name;
	
	// Constructor => 物件初始化的動作
	// 永遠「無」傳回值的宣告，可以是 public, private, protected
	public MyClass01() {  // 一定要跟類別名稱一樣
		System.out.println("MyClass01()");
		var1 = 123;
		name = "Brad";
	}
	
	public MyClass01(int a) {  // 相同 Constructor 但可放不同參數
		System.out.println("MyClass01(int)");
		var1 = a;
		name = "OK";
	}
	
	
	public void m1() {
		System.out.println("MyClass01: m1()");
	}
	
	public void m2() {
		System.out.println("MyClass02: m2()");
	}
	
	
}
