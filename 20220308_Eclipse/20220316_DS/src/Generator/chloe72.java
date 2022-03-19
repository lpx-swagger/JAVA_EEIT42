package Generator;

import java.util.LinkedList;

public class chloe72 {

	public static void main(String[] args) {
		LinkedList<Integer> llist = new LinkedList<>();
		for(int i = 0; i < 10; i++) {
			llist.add(i); // 0123456789
			llist.add(0, i);  // 9876543210
		}
		
		System.out.println(llist);
		
	}

}
