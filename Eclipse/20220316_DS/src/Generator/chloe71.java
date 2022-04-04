package Generator;

import java.util.LinkedList;

public class chloe71 {
	public static void main(String[] args) {
		LinkedList<Integer> llist = new LinkedList<>();
		llist.add(0); llist.add(234); llist.add(6); llist.add(7);
		System.out.println(llist.size());
		System.out.println(llist);
		llist.add(3, 66);
		System.out.println(llist);
		llist.set(3, 67);
		System.out.println(llist);
	}

}
