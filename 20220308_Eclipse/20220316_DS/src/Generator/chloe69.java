package Generator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

// Lottery 改寫方法
// Interface Collection<E>
public class chloe69 {
	public static void main(String[] args) {
		HashSet<Integer> lottery = new HashSet<>();  // 泛型<>，只要符合<>的型別，通通可以被收集起來； Set 天生就 不會重覆
//		TreeSet<Integer> lottery = new TreeSet<>(); // 二元樹
		
		while (lottery.size() < 6) {
			lottery.add((int)Math.random()*49 + 1);  // 不需檢查是否重覆，他天生就不重覆
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
