package Generator;

public class chloe48 {
	public static void main(String[] args) {
		chloe482 obj1 = new chloe482();
		chloe483 obj2 = new chloe482(); // 我需一個認證工程師(chloe483)，那個類別都沒關係，只要符合chloe483規格的物件實體都可以
		chloe481 obj3 = new chloe482(); // interface 無法用new處理，後面會教
		obj1.
		

	}

}


/*interface => 規格 => 你要定義規格，「沒有實作」出來 => 供全世界使用 => public 
 Requirement: 需考過JAVA認證證照，才能來面試
 候選人1. A 考過證照的JAVA認證工程師，可以面試 => 因為符合規格
 候選人2. B 找槍手代考也考過了，可以面試 => 因為符合規格
 候選人3. C 小狗考過了JAVA認證工程師也考過了，可以面試 => 因為符合規格
 ex. java.util => Interface List<E> 裡的 Method 都要做到，才符合規格
 */
interface chloe481 { 
	void m1();
	int m1(int a);
	void m2();
} //若是小型專案，利用別人的interface

interface chloe483 {
	void m4();
}


/* interface裡的method只要有其中一個沒有做到 => 你需要做又沒做 => abstract class */
//abstract class chloe482 implements chloe481 { // 你需要做又沒做 => abstract
//	public void m1() {};
//	//void m2() {};  => 沒有
//	//void m1(int a) {} => 你自訂，與規格無關
//	public void m2() {};
//}
// abstract 存在 inheriented 關係

// abstract 可以讓我想用什麼拿來用就好，其餘的可以不用拿


/* 在做 extends 是單一繼承的觀念，但在「規格implement」是可以
 多個實作 ex. Linux認證，JAVA認證... 但是親生父親只有一個 */
class chloe482 implements chloe481, chloe483 { // 介面的 implements 可以多重
	public void m1() {};
	public int m1(int a) {return 1;}; // because wo void, 需有return
	public void m2() {};
	void m3() {}; // 此行是：其他除了interface要implement以外的部分
	public void m4() {};
}


