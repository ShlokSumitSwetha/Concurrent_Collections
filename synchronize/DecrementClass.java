package Complete_Concurrent_Collections.synchronize;

public class DecrementClass implements Runnable{
	
	Thread t;
	
	public DecrementClass(){
		t=new Thread(this);
		t.start();
	}

	
	@Override
	public void run() {
		
		try {
			System.out.println("B thread requesting for permit");
			System.out.println(t.getState());
		
			System.out.println(t.getState());
			System.out.println("B thread granted Access");
			for(int i=0;i<10;i++){
			SharedResourceAccess.decrement();
			System.out.println("decremented the shared resource"+SharedResourceAccess.count);
			Thread.sleep(1000);
			}
			
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	
	}
}
