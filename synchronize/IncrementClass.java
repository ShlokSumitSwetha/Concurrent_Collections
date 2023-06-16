package Complete_Concurrent_Collections.synchronize;


public class IncrementClass implements Runnable{
	Thread t;
	
	public IncrementClass(){
		t=new Thread(this);
		t.start();
	}

	@Override
	public void run() {
		
		try {
			System.out.println("A thread requesting for permit");
			System.out.println(t.getState());
			System.out.println("A thread granted Access");
			
			for(int i=0;i<10;i++){
			SharedResourceAccess.increment();
			System.out.println("incremented the shared resource"+SharedResourceAccess.count);
			Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
