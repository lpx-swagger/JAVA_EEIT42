package Generator;

public class forLoopTest {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			if (i == 7) {
				break;
			}
			if (i % 2 == 0) {
				continue;
			}
			System.out.println(i); // 跑到 continue ，就不會跑這行
		}
		System.out.println("Game over");
	}
}