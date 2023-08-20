package Complete_Concurrent_Collections.semaphore;

import java.util.concurrent.Semaphore;

public class DecrementClass implements Runnable{
	Semaphore semaphore;
	Thread t;
	
	public DecrementClass(Semaphore semaphore){
		this.semaphore=semaphore;
		t=new Thread(this);
		t.setName("Decrement Thread");
		t.setPriority(4);
		t.start();
	}

	
	@Override
	public void run() {
		
		try {
			System.out.println(Thread.currentThread().getName()+"requesting for permit");
			semaphore.acquire();
			System.out.println(Thread.currentThread().getName()+"granted Access");
			for(int i=0;i<10;i++){
			SharedResourceAccess.count--;
			System.out.println("decremented the shared resource"+SharedResourceAccess.count);
			Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	//once done release lock
		semaphore.release();
	}
}
