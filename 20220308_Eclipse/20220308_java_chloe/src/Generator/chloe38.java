package Generator;

import MyClass.Test01;
import MyClass.Test02;
import MyClass.Test03;

public class chloe38 {   /* 編譯後，任何一個類別一定有一個以上的 constructor, 若是無傳參數建構式，會去讀取父建構式，確保有一個以上的constructor*/

	
	// Constructor
	public static void main(String[] args) {
		Test01 test01 = new Test01();
		System.out.println("---");
		Test02 test02 = new Test02();
		System.out.println("---");
		Test03 test03 = new Test03();
	}

}
