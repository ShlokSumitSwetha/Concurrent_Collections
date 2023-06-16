package Complete_Concurrent_Collections.producer_consumer_using_semaphore;

public class Consumer implements Runnable {

	FoodFactory food;
	public Consumer(FoodFactory food,String threadName) {
		this.food=food;
		Thread t=new Thread(this);
		t.start();
		t.setName(threadName);
	}

	@Override
	public void run() {
			food.getProduct();
	 
	}
	

}
