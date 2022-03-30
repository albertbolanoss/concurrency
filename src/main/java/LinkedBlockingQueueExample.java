import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

// The LinkedBlockingQueue is an optionally-bounded blocking queue implementation, meaning that the queue size can be specified if needed.
public class LinkedBlockingQueueExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
        executorService.submit(() -> {
            try {
                queue.take();
            }
            catch (InterruptedException e) {
                System.out.println(e);
            }
        });
    }
}
