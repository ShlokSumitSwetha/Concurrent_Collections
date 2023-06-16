package Complete_Concurrent_Collections.delay_queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;

public class Test {

	public static void main(String[] args) {
		BlockingQueue queue=new DelayQueue<>();
		new DelayQueueProducer(queue).start();
		new DelayQueueConsumer("Consumer 1", queue).start();;
	}

}
