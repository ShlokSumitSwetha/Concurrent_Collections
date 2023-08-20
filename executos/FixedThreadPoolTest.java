package Complete_Concurrent_Collections.executors;

import java.util.concurrent.*;


public class FixedThreadPoolTest{
	public static void main(String[] args) throws InterruptedException, ExecutionException {

		// Create a fixed thread pool containing one thread
		ExecutorService fixedPool = Executors.newFixedThreadPool(10);

		/** Runnable usage **/
		for(int i=0;i<100; i++){
			fixedPool.submit(new RunnableTask());
		}

		/** Callable usage **/
		for(int i=0;i<100; i++){
			Future<String> callableResponse = fixedPool.submit(new CallableTask());
			callableResponse.get();
		}
		fixedPool.shutdown(); // shut down
	}

}

class RunnableTask implements Runnable{

	@Override
	public void run() {
		System.out.println("Runnable at work !"+ Thread.currentThread().getName());
	}

}

class CallableTask implements Callable{

	@Override
	public String call() {
		System.out.println("Callable at work !"+ Thread.currentThread().getName());
		return "Callable called";
	}

}

