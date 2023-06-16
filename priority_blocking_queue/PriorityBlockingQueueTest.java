package Complete_Concurrent_Collections.priority_blocking_queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlockingQueueTest {
    public static void main(String[] args) {
        final String[] names =
                {"carol", "alice", "malory", "bob", "alex", "jacobs"};

        final BlockingQueue queue = new PriorityBlockingQueue<>();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < names.length; i++) {
                    try {
                        queue.put(names[i]); // it will wait indefinitly if space not available
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "Producer").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < names.length; i++) {
                        System.out.println(queue.take()); // it will wait indefinitly it it finds an object to take
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Consumer").start();
    }
}