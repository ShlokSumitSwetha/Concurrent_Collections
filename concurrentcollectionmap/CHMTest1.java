package Complete_Concurrent_Collections.concurrentcollectionmap;

import java.util.concurrent.ConcurrentHashMap;

public class CHMTest1 {

	public static void main(String[] args) {
		ConcurrentHashMap map=new  ConcurrentHashMap<>();
		map.put(1, "A");
		map.put(2, "B");
		map.putIfAbsent(3, "C");
		map.putIfAbsent(1, "D");
		map.remove(1,"E");
		map.replace(2, "B", "E");
		System.out.println(map);
	}

}
