package Generator;

// TODO

// 列舉 enum
// 桿子觸碰球，反彈回去，用鍵盤控制
// mysql 也有 enum => 可以避免填入我不想要user填入的值，我要他只能填入某些值 ex. 性別: F/M

public class chloe100 {
//	// 老師常用方法:
//	private static int UP = 0;
//	private static int DOWN = 1;
//	private static int LEFT = 2;
//	private static int RIGHT = 3;
//	private static int STOP = 4;
//	public static void main(String[] args) {
// 老師常用方法		int mydir = UP;   // String 也可這樣呈現 
//	}
	
	public static void main(String[] args) {
		Dir dir = Dir.RIGHT;
		System.out.println(dir.name());
		System.out.println(dir.getValue());
		System.out.println(dir.toString());
		
		switch (dir) {
			case UP: System.out.println("up..."); break;
			case DOWN: System.out.println("down..."); break;
			case LEFT: System.out.println("left..."); break;
			case RIGHT: System.out.println("right..."); break;
			case STOP: System.out.println("stop..."); break;
		}
	}
	

}


// enum => 另一種表現，不使用也沒關係
enum Dir {
//	UP, DOWN, LEFT, RIGHT, STOP;  // 列舉項目寫最前, 骨子裏就是 類別
	UP(1), DOWN(2), LEFT(3), RIGHT(4), STOP(0);  // 可代值，因為並不是使用 無傳參數建構式產生的，會有error
	private int value;
	Dir() {   // => 骨子裏就是 private, 有去做 constructor的行為
		System.out.println("OK");
	}
	
	Dir(int a) {
		value = a;
	}
	
	int getValue() {
		return value;
	}
	
	
}