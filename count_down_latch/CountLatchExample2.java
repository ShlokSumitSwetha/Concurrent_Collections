package Complete_Concurrent_Collections.count_down_latch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.*;

class CountDownDemo implements Runnable{
	private CountDownLatch latch;
    private AtomicInteger count;

    public CountDownDemo( CountDownLatch latch,  AtomicInteger count){
        this.latch = latch;
        this.count = count;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("count before"+latch.getCount());
        latch.countDown();
        System.out.println("count after"+latch.getCount()+"Atomic Number:"+count.incrementAndGet());
    }
}


public class CountLatchExample2  {

   static AtomicInteger count = new AtomicInteger();
	
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(24);
       
        for (int i = 0; i < 25; i++) {
			new Thread(new CountDownDemo(latch, count)).start();
		}
       
        

        try {
            latch.await();
          
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("all process completed");
    }

    
}