package MyClass;

public class twID {
	//String letters = "ABCDEFGHJKLMNPQRSTUVXYWZIO"; /*此時此刻，letters 搖身一變從區域變數變成物件變數*/ 
	private static String letters = "ABCDEFGHJKLMNPQRSTUVXYWZIO";  
	String id;
	public twID(String id) {
		this.id = id;
	}
	
	public static boolean checkId(String id) {
		boolean result = false;
		if(id.matches("[A-Z][12][0-9]{8}")) {
			char cha = id.charAt(0);
			//String letters = "ABCDEFGHJKLMNPQRSTUVXYWZIO";
			// ABCDEFGHJKLMNPQRSTUVXYWZIO
			// 01234567890123456789012345
			//           1         2
			int n12 = letters.indexOf(cha) + 10;
			int n1 = n12 / 10;  // pick up tens digits
			int n2 = n12 % 10;  // pick up hundreds digits
			
			int n3 = Integer.parseInt(id.substring(1, 2));
			int n4 = Integer.parseInt(id.substring(2, 3));
			int n5 = Integer.parseInt(id.substring(3, 4));
			int n6 = Integer.parseInt(id.substring(4, 5));
			int n7 = Integer.parseInt(id.substring(5, 6));
			int n8 = Integer.parseInt(id.substring(6, 7));
			int n9 = Integer.parseInt(id.substring(7, 8));
			int n10 = Integer.parseInt(id.substring(8, 9));
			int n11 = Integer.parseInt(id.substring(9, 10));
			
			int sum = n1*1 + n2*9 + n3*8 + n4*7 + n5*6 + n6*5 
					+ n7*4 + n8*3 + n9*2 + n10*1 + n11*1;
			return sum % 10 == 0;	
		}
		
		
		return result;
	}
	
	
	public static void main(String[] args) {
		String id = "B222936816";
		if(twID.checkId(id)) {
			System.out.println("OK");
		} else {
			System.out.println("Failed");
		}
		
	}
	
}
