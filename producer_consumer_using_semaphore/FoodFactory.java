package Complete_Concurrent_Collections.producer_consumer_using_semaphore;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Semaphore;

public class FoodFactory {
		
	CopyOnWriteArrayList<String> products=new CopyOnWriteArrayList();
		
		Semaphore consumerSema=new Semaphore(0);
		Semaphore producerSema=new Semaphore(8);
		
		
		/**
		 * This method is used to get the products
		 */
		public String  getProduct(){
			String product=null;
			try {
				consumerSema.acquire();
				
				if(!products.isEmpty()){
					product=products.get(0);
					System.out.println("Thread has got the Access="+Thread.currentThread().getName()+"And consumed="+product);
					products.remove(0);
					Thread.sleep(1000);
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace(); 
			}
			
			producerSema.release();
			return product;
		}
		
		/**
		 * This method is used to put the products in factory
		 */
		public void putProducts(String product){
			try {
				producerSema.acquire();
				products.add(product);
				Thread.sleep(1000);
				System.out.println("product has being produced="+product);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			consumerSema.release();
		}
		
		
		
	

}
