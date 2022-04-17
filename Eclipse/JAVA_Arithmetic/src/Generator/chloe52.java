package Generator;

public class chloe52 {
	public static void main(String[] args) {
		// 在寫 catch 時，父 Exception要放最下面，才可以讓子 Exception先抓到
		int a = 10, b = 3;
		int c;
		int[] d = {1,2,3,4};

		try {
			c = a / b;
			System.out.println(c);
			System.out.println(d[1000000]);
		}catch (ArithmeticException e1) {
			
		}catch (ArrayIndexOutOfBoundsException e1) {
			
		}catch (Exception e1) {
			System.out.println("error2");
		}
		System.out.println("Game Over");
	}

}
