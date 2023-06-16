package Complete_Concurrent_Collections.completable_future;

import java.util.concurrent.CompletableFuture;

public class CompeletableFutureExceptionally2 {
    public static void main(String[] args) throws Exception {
        runTasks(2);
        runTasks(0);

    }
    private static void runTasks(int i) {
        System.out.printf("-- input: %s --%n", i);
        CompletableFuture.supplyAsync(() -> 16 / i)
                .thenApply(input -> input + 1)
                .thenApply(input -> input + 3)
                .exceptionally(exception -> {
                    printThreadInfo("division task");
                    System.out.println("in exceptionally");
                    System.err.println(exception);
                    return 1;
                })
                .thenApply(input -> input * 3)
                .thenAccept(System.out::println);
    }

    private static void printThreadInfo(String desc) {
        System.out.printf("%s, Thread: %s%n", desc, Thread.currentThread().getName());
    }
}
