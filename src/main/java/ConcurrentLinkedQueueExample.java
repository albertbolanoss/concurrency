import java.util.concurrent.*;

// A ConcurrentLinkedQueue is an unbounded, thread-safe, and non-blocking queue.
public class ConcurrentLinkedQueueExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int element = 1;
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<>();

        Runnable offerTask = () -> queue.offer(element);

        Callable<Integer> pollTask = () -> {
            while (queue.peek() != null) {
                return queue.poll().intValue();
            }
            return null;
        };

        executorService.submit(offerTask);
        Future<Integer> returnedElement = executorService.submit(pollTask);

        if (returnedElement.get() != null && returnedElement.get().intValue() == element) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }

        // assertThat(returnedElement.get().intValue(), is(equalTo(element)));
    }
}
