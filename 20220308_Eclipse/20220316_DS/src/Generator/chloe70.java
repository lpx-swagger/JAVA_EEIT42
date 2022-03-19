package Generator;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class chloe70 {

	public static void main(String[] args) {
		Set set = new HashSet(); // HashSet(Class)，Set(Interface)
		set.add("Chloe");
		set.add(123); // auto-boxing
		set.add(12.3);
		set.add("chloe");
		System.out.println(set);
		// Interface 人家已經有傳回 已經完成的物件實體給我們
		Iterator it = set.iterator();
//		Object obj1 = it.next();
//		Object obj2 = it.next();
//		Object obj3 = it.next();
//		Object obj4 = it.next();
//		if(obj3 instanceof Double) {
//			System.out.println("OK");
//		}
		
		while(it.hasNext()) {
			Object obj1 = it.next();
			System.out.println(obj1);
		}
		
		System.out.println("-----");
		for(Object ob : set) {  // for(陣列: 要巡防的可迭代物件)
			System.out.println(ob);
		}
		
	}

}
