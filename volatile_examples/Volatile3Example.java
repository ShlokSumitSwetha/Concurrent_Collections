package Complete_Concurrent_Collections.volatile_examples;

public class Volatile3Example{
	public static void main(String[] args) {
		SharedResource shared =new SharedResource();
		
		new Thread(new WritingThread(shared)).start();
		new Thread(new ReadingThread(shared)).start();
	}
	
}


class SharedResource{
	 public int a=1;
	    public int b=1;
	    public volatile int c=1;
}


class WritingThread implements Runnable{
	SharedResource shared;
	public WritingThread(SharedResource shared){
		this.shared=shared;
	}

	@Override
	public void run() {
		System.out.println("writing thread");
		
		shared.a=10;
		shared.b=10;
		shared.c=10;
		
	}
	
}


class ReadingThread implements Runnable{
	SharedResource shared;
	public ReadingThread(SharedResource shared){
		this.shared=shared;
	}
	@Override
	public void run() {
		System.out.println("reading the thread");
		System.out.println(shared.a);
		System.out.println(shared.b);
		System.out.println(shared.c);
		
	}
	
}