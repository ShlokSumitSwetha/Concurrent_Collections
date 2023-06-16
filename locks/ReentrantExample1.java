package Complete_Concurrent_Collections.locks;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantExample1 {
	public static void main(String[] args) {
		ReentrantLock l=new ReentrantLock();
		l.lock();
		l.lock();
		System.out.println("Is thread locked="+l.isLocked());
		System.out.println("is current thread held="+ l.isHeldByCurrentThread());
		System.out.println("queue thread length="+l.getQueueLength()); // only ReentrantExample1 thread is locked no other thread waiting
		System.out.println("hold count="+l.getHoldCount());
		l.unlock();
		System.out.println("Thread unlock called");
		System.out.println("is thread locked="+l.isLocked());
		System.out.println("hold count="+l.getHoldCount());
		System.out.println("queue thread length="+l.getQueueLength()); // only ReentrantExample1 thread is locked no other thread waiting
		l.unlock();
		System.out.println("thread unlocked");
		System.out.println("hold count="+l.getHoldCount());
		System.out.println("queue thread length="+l.getQueueLength()); // only ReentrantExample1 thread is locked no other thread waiting
	}

}
