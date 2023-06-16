package Complete_Concurrent_Collections.CopyOnWriteArrayList;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class NormlArrayList {

	public static void main(String[] args) {
		List list= new CopyOnWriteArrayList<>();
		list.add("Sumit");
		list.add("swetha");
		list.add("shlok");
		list.add("not");
	
		
		Iterator i =list.iterator();
		while(i.hasNext()){
			Object o=i.next();
			if(o.equals("not"))
				list.remove(o);
		}
		System.out.println("list"+list);
	}
	
}
