package Generator;

public class chloe42 {
	public static void main(String[] args) {
		chloe421 obj1 = new chloe421();
		chloe421 obj2 = new chloe421();
		chloe421 obj3 = new chloe421();
		System.out.println("------");
		chloe421.m2(); 
		chloe421.m2();
		chloe421.m2();
		/* result: 
		   static Brad421{} => 我發現你會用到 該類別(chloe421)，
		   					   static的部分就直接先載入記憶體，
		   .
		   .
		   .
		   .
		   .
		   ------
		   Brad421:static m2() => 但是物件區塊的部分，每次都做
		   Brad421:static m2() => 但是物件區塊的部分，每次都做
		   Brad421:static m2() => 但是物件區塊的部分，每次都做
		*/
		System.out.println("------");
		Brad422.m3();
	}
}

class chloe421 {
	static { /* 靜態記憶體配置區塊，static 他不專屬任一物件，整個 類別 共同擁有的，有類別才有static，我發現到
	你需要用到這個類別，記憶體只需做一次性的載入，不像是物件要一個兩個的待命。
	他沒名字要如何呼叫？ 
	存取範圍？ => 沒得存取，沒有名字就沒辦法存取；但他可以存取物件級別的東西，static 可叫 static 級別的東西
	*/
		System.out.println("static Brad421{}");
	}
	
	
	chloe421() { /* constructor 本身在做初始化 => 不是用來create 物件(object) 
				=> object早就存在，如果constructor 可以產生物件實體，
					JAVA 幹嘛還要求寫「new」，無聊！*/
		System.out.println("Brad421()");
	}
	
	
	/* 不常使用!! ，物件級別的程式區塊，這樣寫 沒得呼叫，所以會跟著物件走，在走 
	   constructor 之前就已經先執行了 => 在初始化之前就執行了 */
	{
		System.out.println("Brad421{}");
		m1(); /* => 為何m1()在這能被呼叫？ => m1() 能被呼叫，表示物件早就存在 
					=> 此時此刻物件已經存在了 => 有 物件 才存在，才可以用 */
	}
	
	
	void m1() {
		System.out.println("Brad421:m1()");
	}
	
	
	static void m2() {
		System.out.println("Brad421: static m2()");
	}
	
}


class Brad422 extends chloe421 {
	static void m3() {
		System.out.println("Brad422: static m3()");
	}
}