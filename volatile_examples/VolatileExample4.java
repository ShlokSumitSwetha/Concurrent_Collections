package Complete_Concurrent_Collections.volatile_examples;
/**
 * This example is used to demonstrate that 
 * 
 * 1. When running variable is just static boolean , thread starts then 
 *  it keep on running with in while loop as initially its false
 *  then thread sleeps for 1 sec then it executes "starting" the running boolean to true 
 *  then thread sleeps for 1 sec then it executes "stopping" the running boolean to false
 * While loop is infinite.
 * 
 * Here problem is that thread executes in its own cache memory and even though boolean flag is changed by main thread 
 * it did not reflected as its value is picking from its own cache memory.
 * 
 * 2. When running variable is  static volatile boolean , thread starts then 
 * it keep on running with in while loop as initially its false
 * then thread sleeps for 1 sec then it executes "starting" the running boolean to true 
 * then thread sleeps for 1 sec then it executes "stopping" the running boolean to false
 * As the variable is static volatile then it variable is not present in it's own cache memory. but it gets its updated value from
 * main memory.
 * 
 * @author Sumith
 *
 */
public class VolatileExample4 implements Runnable{
	private static volatile boolean running=false;
	
	public static void main(String[] args) throws InterruptedException {
		new Thread(new VolatileExample4()).start();
		Thread.sleep(1000);
		System.out.println("starting");
		running=true;
		Thread.sleep(1000);
		System.out.println("stopping");
		running=false;
	}

	@Override
	public void run() {
		while(!running){
			
		}
		System.out.println("started");
		while(running){
			
		}
		System.out.println("stopped");
	}

}
