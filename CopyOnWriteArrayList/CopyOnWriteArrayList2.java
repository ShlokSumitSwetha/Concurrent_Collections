package Complete_Concurrent_Collections.CopyOnWriteArrayList;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayList2 {

	public static void main(String[] args) {
		CopyOnWriteArrayList cowal=new  CopyOnWriteArrayList();
		cowal.add("A");
		cowal.add("B");
		cowal.add("C");
		Iterator it=cowal.iterator();
		cowal.add("D");
		
		while(it.hasNext()){
			System.out.println("value="+it.next());
		}
		
	}

}
