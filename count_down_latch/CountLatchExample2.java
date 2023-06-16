package Complete_Concurrent_Collections.count_down_latch;

import java.util.concurrent.CountDownLatch;

class CountDownDemo implements Runnable{
	private CountDownLatch latch;

    public CountDownDemo( CountDownLatch latch){
        this.latch = latch;
    }
    @Override
    public void run() {

       System.out.println("count before"+latch.getCount());
        latch.countDown();
        System.out.println("count after"+latch.getCount());
    }
}


public class CountLatchExample2  {
   
	
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(9);
       
        for (int i = 0; i < 25; i++) {
			new Thread(new CountDownDemo(latch)).start();
		}
       
        

        try {
            latch.await();
          
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("all process completed");
    }

    
}