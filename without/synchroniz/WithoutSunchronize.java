package Complete_Concurrent_Collections.without.synchroniz;

import java.util.concurrent.TimeUnit;

public class WithoutSunchronize {

	private static  volatile boolean stopRequested;
	public static void main(String[] args) throws InterruptedException {
	
		Thread thread=new Thread(new Runnable() {
			public void run(){
				int i=0;
				while(!stopRequested){
					System.out.println("while i="+i);
					i++;
				}
			}
		});
		thread.start();
		TimeUnit.MICROSECONDS.sleep(1);
		stopRequested=true;
	}

}
