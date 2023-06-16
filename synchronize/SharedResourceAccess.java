package Complete_Concurrent_Collections.synchronize;

public class SharedResourceAccess {
	// shared resource counter
		public static volatile int count;
		
		public static synchronized void increment(){
			count++;
		}
		public static synchronized  void decrement(){
			count--;
		}
}

