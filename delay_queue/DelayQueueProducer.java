package Complete_Concurrent_Collections.delay_queue;

import java.util.UUID;
import java.util.concurrent.BlockingQueue;

public class DelayQueueProducer {
	
	private BlockingQueue queue;
	
   public DelayQueueProducer(BlockingQueue queue){
	   this.queue=queue;
   }
   
   private Thread producerThread=new Thread(new Runnable(){
	   
	   public void run(){
		   
		   while(true){
			   try{
				   int delay=1000000;
				   DelayObject object=new DelayObject(UUID.randomUUID().toString(),delay);
				   System.out.println("put the object"+object);
				   queue.put(object);
				   Thread.sleep(500);
			   }
			   catch(Exception e){
				   
			   }
			   
			   
		   }
	   }
	   
   },"ProducerThread");
   
   public void start(){
	   producerThread.start();
   }
	
}
