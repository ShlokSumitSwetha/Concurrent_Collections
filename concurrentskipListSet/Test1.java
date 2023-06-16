package Complete_Concurrent_Collections.concurrentskipListSet;

import java.util.concurrent.ConcurrentSkipListSet;

public class Test1 {

	public static void main(String[] args) {

		ConcurrentSkipListSet<String> cslset=new ConcurrentSkipListSet<>();
		cslset.add("Sumit");
		cslset.add("Apple");
		cslset.add("Ball");
		System.out.println(cslset);
	}

}
