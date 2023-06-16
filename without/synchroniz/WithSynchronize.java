package Complete_Concurrent_Collections.without.synchroniz;

import java.util.concurrent.TimeUnit;

public class WithSynchronize implements Runnable{
	private static  boolean stopRequested;
	
	private static synchronized void requestStop(){
		stopRequested=true;
	}
	private static synchronized boolean stopRequested(){
		return stopRequested;
	}
	public static void main(String[] args) throws InterruptedException {
			new Thread(new WithSynchronize(),"thread1").start();
			new Thread(new WithSynchronize(),"thread2").start();
		TimeUnit.MICROSECONDS.sleep(1);
		requestStop();
	}
	
	public void run(){
		int i=0;
		while(!stopRequested()){
			System.out.println("while i in with synchronized="+i);
			i++;
		}
	}
}
