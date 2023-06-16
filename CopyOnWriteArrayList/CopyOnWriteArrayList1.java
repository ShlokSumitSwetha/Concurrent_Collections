package Complete_Concurrent_Collections.CopyOnWriteArrayList;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayList1 {

	public static void main(String[] args) {
		List list= new CopyOnWriteArrayList<String>();
		list.add("Sumit");
		list.add("swetha");
		
		Iterator i =list.iterator();
		while(i.hasNext()){
		System.out.println(i.next());
		 list.add("child");
		}
		System.out.println("CopyOnWrite after iteration : " + list);
	}
	 

}
/*
 * Output:n(
 * Sumit
Exception in thread "main" java.util.ConcurrentModificationException
	at java.util.ArrayList$Itr.checkForComodification(ArrayList.java:901)
	at: java.util.ArrayList$Itr.next(ArrayList.java:851)
	at source.concurrenthashmap.CopyOnArrayList.main(CopyOnArrayList.java:14)*/
