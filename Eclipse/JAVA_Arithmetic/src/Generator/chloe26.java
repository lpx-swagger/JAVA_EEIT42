package Generator;

//from: EEIT36 Brad35

public class chloe26 {
	public static void main(String[] args) {
		chloe262 obj1 = new chloe262();
		chloe261 obj2 = new chloe262();
		chloe263 obj3 = new chloe262();
		
		// 全部都由Brad352來做出物件實體，但是你可以試著 obj1. 看 按.之後 都有這個5種方法 m1(), m1(int), m2(), m3(), m4()
		//obj1.
		//obj2.  => #3方法，因為你一開始 宣告成 Brad351
		//obj3.  => #1方法
	}
}

/*interface => 規格 => 你要定義規格，「沒有實作」出來 若拿去實作絕對是更擴大，不會更小 => 供全世界使用 => public
認證要求: 需考過JAVA認證證照，才能來面試
候選人1. A 考過證照的JAVA認證工程師，可以面試 => 因為符合規格
候選人2. B 找槍手代考也考過了，可以面試 => 因為符合規格
候選人3. C 小狗考過了JAVA認證工程師也考過了，可以面試 => 因為符合規格
ex. java.util => Interface List<E> 裡的 Method 都要做到，才符合規格
*/

// interface 介面 = abstract = 沒實作 => 規格(可以實作多個) => 定義規格
interface chloe261 {
	void m1();
	int m1(int a);
	void m2();
}  //若是小型專案，利用別人的interface

interface chloe263 {
	void m4();
}

/* 在做 extends 是單一繼承的觀念，但在「規格implement」是可以
多個實作 ex. Linux認證，JAVA認證... 但是親生父親只有一個 */
class chloe262 implements chloe261, chloe263 { // 介面的 implements 可以多重
	public void m1() {};
	public int m1(int a) {return 1;}; // because wo void, 需有return
	public void m2() {};
	void m3() {}; // 此行是：其他除了interface要implement以外的部分
	public void m4() {};
}

