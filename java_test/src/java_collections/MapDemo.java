package java_collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class MapDemo {

	public static void main(String[] args) {

		HashMap map = new HashMap();
		map.put("Car", 20001.0);
		map.put(1233, "john");
		map.put(100, 23311);
		map.put(400, true);
		map.put("john", false);

		System.out.println(map);

		System.out.println("=======");

		Set entrySet = map.entrySet();

		for (Object entry : entrySet) {
			System.out.print(entry + "  ");
		}

		System.out.println("=======");

		Set keySet = map.keySet();

		for (Object entry : keySet) {
			System.out.print(entry + "  ");
		}

		System.out.println("=======");

		Collection values = map.values();

		for (Object entry : values) {
			System.out.print(entry + "  ");
		}

		System.out.println("=======");
		
		System.out.println(map.size());
	}
}
