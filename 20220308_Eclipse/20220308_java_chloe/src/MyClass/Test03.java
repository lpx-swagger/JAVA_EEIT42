package MyClass;

public class Test03 extends Test02{
	//Constructor
	public Test03() {
		//super(); // 隱含在內，為了確保你要做，你要做 construtor,你的祖宗8代都要先做constructor
		// super() 呼叫parents 的建構式
		super(1); // 另外指定 value，若有寫建構式,就需尊重設計者
		System.out.println("Test03");
	}
	
	public Test03(int a) {
		this(); // 是否呼叫父類別？
	}
	
	public Test03(double b) {
		this("bb");
	}
	
	public Test03(String c) {
		this(2.0);
	}
}
