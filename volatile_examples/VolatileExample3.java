package Complete_Concurrent_Collections.volatile_examples;



public class VolatileExample3 {  
	public  static volatile int testValue = 1; 
public static void main(String args[]) {  
    new ExampleThread("Thread 1 ").start();  
    new ExampleThread("Thread 2 ").start();  
}  


static class ExampleThread extends Thread {  
	
public ExampleThread(String str){  
    super(str);  
}  
public void run() {  
    for (int i = 0; i < 3; i++) {  
        try {  
            System.out.println(getName() + " loop count: "+i);  
            if (getName().compareTo("Thread 1 ") == 0)  
            {  
                testValue++;  
                System.out.println( "Test Value T1: " + testValue);  
            }  
            if (getName().compareTo("Thread 2 ") == 0)  
            {  
                System.out.println( "Test Value T2: " + testValue);  
            }                 
            Thread.sleep(1000);  
        } catch (InterruptedException exception) {  
            exception.printStackTrace();  
          }  
       }  
       }  
       }
}