import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ConcurrentLinkedQueueMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int element = 1;
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Collection<Integer> collection = Arrays.asList(2);
        ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<>(collection);

        Runnable offerTask = () -> queue.offer(element);

        Callable<Integer> pollTask = () -> {
            while (queue.peek() != null) {
                return queue.poll().intValue();
            }
            return null;
        };

        executorService.submit(offerTask);
        Future<Integer> returnedElement = executorService.submit(pollTask);
        System.out.println(returnedElement.get().intValue() + " " +  element);
    }
}
