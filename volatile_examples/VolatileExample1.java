package Complete_Concurrent_Collections.volatile_examples;
/**
 * one thread repeatedly calls the method one (but no more than Integer.MAX_VALUE times in all), 
 * and another thread repeatedly calls the method two:
 * @author Sumit
 *
 */
public class VolatileExample1 {
		
	
	public static void main(String[] args) {
		System.out.println("starting");
		new Thread1();
		new Thread2();
	}
}	

class SynchronizedMethod{
	static int i = 0, j = 0;
    static synchronized void one() { 
    	i++; 
    	j++;
    	}
    static synchronized void two() {
        System.out.println("i=" + i + " j=" + j);
    }
}

class WithoutSynchronizedMethod{
	static int i = 0, j = 0;
    static  void one() { 
    	i++; 
    	j++;
    	}
    static  void two() {
        System.out.println("i=" + i + " j=" + j);
    }
}
class VolatileVariable{
	static volatile int i = 0, j = 0;
    static  void one() { 
    	i++; 
    	j++;
    	}
    static  void two() {
        System.out.println("i=" + i + " j=" + j);
    }
}


	class Thread1 implements Runnable{
		public Thread1(){
			Thread t1=new Thread(this);
			t1.start();
		}
	
		@Override
		public void run() {
			while(true){
				
				//SynchronizedMethod.one();
				//WithoutSynchronizedMethod.one();
				VolatileVariable.one();
			}
		}
	}

class Thread2 implements Runnable{
	public Thread2(){
		Thread t=new Thread(this);
		t.start();
	}
	@Override
	public void run() {
		while(true){
			//SynchronizedMethod.two();
			//WithoutSynchronizedMethod.two();
			VolatileVariable.two();
		}
	}
}
