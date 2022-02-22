import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class SquareCalculator {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {

        Future<Integer> future = new SquareCalculator().calculate(10);

        // Cancel a future task
        // boolean cancel = future.cancel(true);

        // This is only an wait
        while(!future.isDone()) {
            System.out.println("Calculating...");
            Thread.sleep(300);
        }

        Integer result = future.get(500, TimeUnit.MILLISECONDS);
        System.out.println(result);
    }

    public static Future<Integer> calculate(Integer input) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        return executor.submit(() -> {
            Thread.sleep(1000);
            return input * input;
        });
    }
}
