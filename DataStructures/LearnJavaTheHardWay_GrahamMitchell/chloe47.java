
// #47 Generating and filtering values

/*
	Farmer Brown wants to spend exactly $100.00 and wants to purchase exactly 100 animals. 
	If sheep cost $10 each, goats cost $3.50 each and chickens are $0.50 apiece, then 
	how many of each animal should he buy? (He wants at least one of each type of animal.)
*/
public class chloe47 {
	public static void main(String[] args) {
		for(int s = 1; s <= 100; s++) {
			for(int g = 1; g <= 100; g++) {
				for(int c = 1; c <= 100; c++) {
					if (s + g + c == 100 && s*10.00 + g*3.50 + c*0.50 == 100.00) {
						System.out.println(s + " sleep, ");
						System.out.println(g + " goats, ");
						System.out.println(c + " chickens, ");
					}			
				}
			}
		}
	}
}