package Generator;

import myClass.BCrypt;

public class chloe91 {
	public static void main(String[] args) {
		String pass = "123456";
		String hashPass = BCrypt.hashpw(pass, BCrypt.gensalt());
		System.out.println(hashPass);
		System.out.println(hashPass.length());
		
		if(BCrypt.checkpw("1234567", hashPass)) {
			System.out.println("OK");
		} else {
			System.out.println("XX");
		}
	}

}
