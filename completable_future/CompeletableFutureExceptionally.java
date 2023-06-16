package Complete_Concurrent_Collections.completable_future;

import java.util.concurrent.CompletableFuture;

public class CompeletableFutureExceptionally {
    public static void main(String[] args) throws Exception {
        System.out.println("-- running CompletableFuture --");
        CompletableFuture<Integer> completableFuture = CompletableFuture
                .supplyAsync(() -> {
                    System.out.println("running task");
                    printThreadInfo("division task");
                    return 10 / 0;
                }).exceptionally(exception -> {
                    System.err.println("exception: " + exception);
                    printThreadInfo("exception task");
                    return 1;
                });
        Thread.sleep(3000);//let the stages complete
        System.out.println("-- checking exceptions --");
        boolean b = completableFuture.isCompletedExceptionally();
        System.out.println("completedExceptionally: " + b);
        System.out.println("-- getting results --");
        int result = completableFuture.get();
        System.out.println(result);

    }

    private static void printThreadInfo(String desc) {
        System.out.printf("%s, Thread: %s%n", desc, Thread.currentThread().getName());
    }
}
