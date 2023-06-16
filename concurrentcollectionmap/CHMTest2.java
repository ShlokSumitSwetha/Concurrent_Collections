package Complete_Concurrent_Collections.concurrentcollectionmap;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class CHMTest2 extends Thread{
private static ConcurrentHashMap map=new ConcurrentHashMap();
	
	public static void main(String[] args) throws InterruptedException {
		map.put(1, "A");
		map.putIfAbsent(2, "B");
		CHMTest2 thread=new CHMTest2();
		thread.start();

		Set s1=map.keySet();
		Iterator it=s1.iterator();
		while(it.hasNext()){
			Integer I1=(Integer)it.next();
			System.out.println("main thread Iterating the map and current entry is key="+I1+"value="
					+ "value="+map.get(I1));
			Thread.sleep(3000);
		}

	}
	public void run(){
		try{
			Thread.sleep(2000);
			
		}
		catch(Exception e){
			
		}
		map.put(3, "C");
		System.out.println("child Thread Updating values");
	}

}
