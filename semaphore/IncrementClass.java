package Complete_Concurrent_Collections.semaphore;

import java.util.concurrent.Semaphore;

public class IncrementClass implements Runnable{

	Semaphore semaphore;
	Thread t;
	public IncrementClass(Semaphore semaphore){
		this.semaphore=semaphore;
		t=new Thread(this);
		t.start();
	}

	@Override
	public void run() {
		
		try {
			System.out.println("A thread requesting for permit");
			System.out.println(t.getState());
			System.out.println("Semaphore Permit Count before acquire() called"+semaphore.availablePermits());
			semaphore.acquire();
			System.out.println(t.getState());
			System.out.println("A thread granted Access");
			System.out.println("Semaphore Permit Count after acquire() called"+semaphore.availablePermits());
			for(int i=0;i<10;i++){
			SharedResourceAccess.count++;
			System.out.println("incremented the shared resource"+SharedResourceAccess.count);
			Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	  //once done release lock
		semaphore.release();
		System.out.println("Semaphore Permit Count after release() called"+semaphore.availablePermits());
	}

}
