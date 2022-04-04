package MyClass;

public class twID {
	
	private String id;
	//String letters = "ABCDEFGHJKLMNOPQRSTUVXYWZIO";
	//static String letters = "ABCDEFGHJKLMNOPQRSTUVXYWZIO";
	private static String letters = "ABCDEFGHJKLMNOPQRSTUVXYWZIO";
	
	public twID() {
		
	}
	
//	public twID(String id){
	private twID(String id) {
		this.id = id;
	}
	
	public twID(int area) {
		// 隨機產生
	}
	
	public twID(boolean gender) {
		// 隨機產生
	}
	
	public twID(int area, boolean gender) {
		// 隨機產生
		StringBuffer sb = new StringBuffer(letters.substring(area, area+1));
		sb.append(gender?"1":"2");   // 三元運算式
		// middle #7
		for (int i = 0; i < 7; i++) {
			int rand = (int)(Math.random()*7);
			System.out.println(rand);
		}
		
		// 最後數字 0 to 9
		String tmp = sb.toString();
		for(int i = 0; i < 10; i++) {
			if (checkId(tmp+i)) {
				
			}
			//tmp.concat(i);
		}
		
	}
	
	// create owner id
	public static twID createId(String urId) {
		twID createUrId = null;
		if(checkId(urId)) {
			 new twID(urId); 
		}
		
		return null;
	}
	
	
	
	public static boolean checkId(String id) {
		
		// check length
		if (id.length() == 10) {
			return true;
		}
		
		
		// check first letter
		boolean isValid = false;
		String s1 = "[A-Z]";
		char cha1 = id.charAt(0);
		
		String tmp = String.valueOf(cha1);
		
		if (s1.matches(tmp)) {
			return true;
		}

		
		// check index[0] is Upper Case
		if (!s1.matches("[A-Z]")) {
			return false;
		}
		
		
		// index[1] have to be 1, 2
		int idConvert = id.codePointAt(1);
		if (idConvert != 1 || idConvert != 2 ) {
			return false;
		}
		
		
		// fomula array
		int sum = 0;
		for (int i = 2; i < 9; i++) {
			for (int j = 3; j < 10; j++) {
				Integer.parseInt(id.substring(i, j));
				sum += sum + j;
			}
		}
		
		 
		
		// temp void
		return true;
	}
	
	
	public static void main(String[] args) {	
		if(twID.checkId("A323456789")) {
			System.out.println("OK\n");
		} else {
			System.out.println("Failed\n");
		}
		

	}
	

}
