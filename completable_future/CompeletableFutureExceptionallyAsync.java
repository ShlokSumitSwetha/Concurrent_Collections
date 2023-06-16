package Complete_Concurrent_Collections.completable_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompeletableFutureExceptionallyAsync {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        CompletableFuture.supplyAsync(() -> {
            printThreadInfo("division task");
            return 10 / 0;
        }).exceptionallyAsync(exception -> {
                    printThreadInfo("exceptionally Async");
                    System.err.println("exception: " + exception);
                    return 1;
                }, executor
        ).thenApply(input -> {
            printThreadInfo("multiply task");
            return input * 3;
        }).thenAccept(System.out::println);

        Thread.sleep(2000);//let the stages complete
        executor.shutdown();
    }
    private static void printThreadInfo(String desc) {
        System.out.printf("%s, Thread: %s%n", desc, Thread.currentThread().getName());
    }
}
