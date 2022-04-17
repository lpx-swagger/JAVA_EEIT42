package Generator;

public class chloe45 {
	public static void main(String[] args) {
		badGuy b1 = new badGuy1();
		badGuy b2 = new badGuy2();
		badGuy b3 = new badGuy3();
		attack(b1);
		attack(b2);
		attack(b3);
	}
	
	static void attack(badGuy badman) {
		if(badman instanceof badGuy1) {
			System.out.println("bman1: ");
		} else if(badman instanceof badGuy2) {
			System.out.println("bman2: ");
		} else if(badman instanceof badGuy3) {
			System.out.println("bman3: ");
		}
		
		badman.shooting();
		System.out.println();
	} 
	
	
}


class badGuy {
	void shooting() {
		System.out.println("badGuy:shooting()");
	}
	
}

class badGuy1 extends badGuy {
	void shooting() {
		System.out.println("badGuy1:shooting()");
	}
}


class badGuy2 extends badGuy {
	void shooting() {
		System.out.println("badGuy2:shooting()");
	}
}

class badGuy3 extends badGuy {
	void shooting() {
		System.out.println("badGuy3:shooting()");
	}
}