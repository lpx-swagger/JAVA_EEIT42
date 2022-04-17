package Generator;

public class chloe54 {
	public static void main(String[] args) {
		chloe541 obj = new chloe541();
		obj.m1(2);
	}
}


class chloe541 {
	void m1(int a){
		try {
			m2(a);
			System.out.println("OK0");
		}catch (Exception e) {
			System.out.println("OK1");
			return;
		}finally {
			System.out.println("OK3");
		}
		System.out.println("OK2");
	}
	void m2(int a) throws Exception{
		m3(a);
	}
	void m3(int a) throws Exception {
		if (a >= 0) {
			System.out.println("m3()");
		}else {
			throw new Exception();			
		}
	}
}
