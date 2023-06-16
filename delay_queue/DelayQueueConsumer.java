package Complete_Concurrent_Collections.delay_queue;

import java.util.concurrent.BlockingQueue;

public class DelayQueueConsumer {
	private String name;
	private BlockingQueue queue;
	
	public DelayQueueConsumer(String s, BlockingQueue q){
		this.name=s;
		this.queue=q;
	}
	

	private Thread consumerThread =new Thread(new Runnable(){
		
		public void run(){
			while(true){
				try{
					DelayObject object=(DelayObject) queue.take();
					System.out.println("taking the object"+Thread.currentThread().getName()+object);
					 Thread.sleep(1000);
				}
				catch(Exception e){
					
				}
			}
		}
	});
	
	public void start(){
		this.consumerThread.setName(name);
		this.consumerThread.start();
	}
}
