package Complete_Concurrent_Collections.count_down_latch;

import java.util.concurrent.CountDownLatch;

class Event implements Runnable{

	CountDownLatch cdlatch;
	
	public Event(CountDownLatch cdlatch) {
		new Thread(this).start();
		this.cdlatch=cdlatch;
	}

	@Override
	public void run() {
		for(int i=1;i<60;i++){
			System.out.println("Thread looping number "+i);
			System.out.println("Count Down Latch before Count"+cdlatch.getCount());
			cdlatch.countDown();
			System.out.println("Count Down Latch after count"+cdlatch.getCount());
		}
		
	}

}

public class CountDownLatchTest {

	public static void main(String[] args) {
		CountDownLatch cdlatch=new CountDownLatch(10);
		new Event(cdlatch);
		
		try {
			cdlatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("event executed done!");
		
	}

}
