package Complete_Concurrent_Collections.volatile_examples;
/**
 * This program demonstrates that with 
 * 1. Just int for a and b variable time is 10ms
 * 2. With volatile int for a and b variables then it takes 120ms
 * 
 * volatile takes more time than normal variable
 * 
 * @author Sumith
 *
 */
public class VolatileExample5{
	private  volatile int a=0;
	private volatile int b=0;
	
	private static long timerA;
	private static long timerB;
	
	public static void main(String[] args) throws InterruptedException {
		final VolatileExample5 instance=new VolatileExample5();
		
		new Thread(new Runnable(){
			@Override
			public void run() {
				timerA=System.nanoTime();
				while(true){
					instance.a++;
					if(instance.a% 100_000_000==0){
						System.out.println("A time="+(System.nanoTime()-timerA)/10000000+"ms");
						instance.a=0;
						timerA=System.nanoTime();
					}
				}
			}
			
		}).start();
		
		new Thread(new Runnable(){
			@Override
			public void run() {
				timerB=System.nanoTime();
				while(true){
					instance.b++;
					if(instance.b% 100_000_000==0){
						System.out.println("B time="+(System.nanoTime()-timerB)/10000000+"ms");
						instance.b=0;
						timerB=System.nanoTime();
					}
				}
			}
		}).start();
	}
}
