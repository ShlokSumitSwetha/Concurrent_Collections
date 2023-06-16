package Complete_Concurrent_Collections.executos;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;



public class FixedThreadPoolTest{
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // Create a fixed thread pool containing one thread
    	
    	int nbThreads =  Thread.getAllStackTraces().keySet().size();
    	System.out.println("number of threads created before executor="+nbThreads);
    	int nbRunning2 = 0;
    	for (Thread t : Thread.getAllStackTraces().keySet()) {
    	    if (t.getState()==Thread.State.RUNNABLE) nbRunning2++;
    	}
    	System.out.println("runnabletheread="+nbRunning2);
        ExecutorService fixedPool = Executors.newFixedThreadPool(4);
        
       
        //ExecutorService fixedPool = Executors.newCachedThreadPool();
 
        Future<String> callableFuture = fixedPool.submit(new CallableClass());
        
        int nbThreads2 =  Thread.getAllStackTraces().keySet().size();
    	System.out.println("number of threads created after executor="+nbThreads2);
        
    	
        System.out.println("result from the callable="+callableFuture.get());
        callableFuture.cancel(true);
        if(callableFuture.isDone()){
        	System.out.println("callable done!s");
        }
        callableFuture.cancel(false);
        if(callableFuture.isCancelled()){
        	System.out.println("callable cancelled!s");
        }
        
        Future<?> runnableFuture = fixedPool.submit(new RunnableClass());
        
        System.out.println("result from the runnable=" +runnableFuture.get());
 
        fixedPool.shutdown(); // shut down
        int nbRunning = 0;
    	for (Thread t : Thread.getAllStackTraces().keySet()) {
    	    if (t.getState()==Thread.State.RUNNABLE) nbRunning++;
    	}
    	
    	System.out.println("runnabletheread="+nbRunning);
    }
}

/**
 * Here is the callable class
 * @author Sumit
 *
 */
class CallableClass implements Callable{

	@Override
	public String call() throws Exception {
		String s="Callable returned";
		// Print a value
        System.out.println("Callable at work !");
        // Sleep for 5 sec
        Thread.sleep(5 * 1000);
        return s;
		
	}
	
}


/**
 * Here is the Runnable classs
 * @author Sumit
 *
 */
class RunnableClass implements Runnable{

	@Override
	public void run() {
		 try {
             // Print a value
             System.out.println("Runnable at work !");
             // Sleep for 5 sec
             Thread.sleep(5 * 1000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
		
	}
	
}
