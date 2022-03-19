package Generator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class chloe69 {

	public static void main(String[] args) {
		HashSet<Integer> lottery = new HashSet<>();  // Set 天生就 不會重覆
//		TreeSet<Integer> lottery = new TreeSet<>(); // 二元樹
		while (lottery.size() < 6) {
			lottery.add((int)Math.random()*49 + 1);
		}
		System.out.println(lottery.toString());;

		// Method: for-each 巡防
		for(Object ob : lottery) {
			System.out.println(ob);
		}
		
		// Method: iterator 巡防
		Iterator<Integer> it = lottery.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		

		
		
	}

}
