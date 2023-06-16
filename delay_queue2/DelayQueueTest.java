package Complete_Concurrent_Collections.delay_queue2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;

public class DelayQueueTest {

	public static void main(String[] args) throws InterruptedException {

		BlockingQueue queue=new DelayQueue<>();
		
		DelayObject object1=new DelayObject("SUMIT", 1000000);
		DelayObject object2=new DelayObject("Swetha", 500);
		DelayObject object3=new DelayObject("Shlok", 100);
		
		queue.put(object1);
		queue.put(object2);
		queue.put(object3);
		System.out.println("remaining capacity"+queue.remainingCapacity());
		
		while(true){
			System.out.println(System.currentTimeMillis());
			DelayObject object=(DelayObject) queue.take();
			System.out.println("removed object="+object.data);
			System.out.println("its start Time"+object.startTime);
		}
	}

}
