package Complete_Concurrent_Collections.producer_consumer_using_semaphore;

public class Producer implements Runnable{

	FoodFactory food;
	
	public Producer(FoodFactory food) {
		new Thread(this).start();
		this.food=food;
	}

	@Override
	public void run() {
		for(int i=0;i<20;i++){
		String s="product_"+i;
			food.putProducts(s);
		}
	}

}
