package Complete_Concurrent_Collections.producer_consumer_using_semaphore;

public class ProducerConsumerTest {

	public static void main(String[] args) {
		FoodFactory food=new FoodFactory();
		new Producer(food);
		new Consumer(food,"A");
		new Consumer(food,"B");
		new Consumer(food,"C");
		new Consumer(food,"D");
		new Consumer(food,"E");
	}

}

/*output:
product has being produced=product_0
Thread has got the Access=AAnd consumed=product_0
product has being produced=product_1
Thread has got the Access=CAnd consumed=product_1
product has being produced=product_2
Thread has got the Access=DAnd consumed=product_2
product has being produced=product_3
Thread has got the Access=BAnd consumed=product_3
product has being produced=product_4
Thread has got the Access=EAnd consumed=product_4
product has being produced=product_5
product has being produced=product_6
product has being produced=product_7
product has being produced=product_8
product has being produced=product_9
product has being produced=product_10
product has being produced=product_11
product has being produced=product_12*/
