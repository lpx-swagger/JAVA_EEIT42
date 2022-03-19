package Generator;

import java.util.HashMap;
import java.util.Set;

public class chloe73 {

	public static void main(String[] args) {
		HashMap<String, Object> person = new HashMap<String, Object>();
		person.put("Height", 183);
		person.put("Gender", true);
		person.put("Name", "Luis");
		person.put("Weight", 58.88);
		
		Set<String> keys = person.keySet();
		
		for(String pk : keys) {
			System.out.println(pk + ":" + person.get(pk));
		}
	}

}
