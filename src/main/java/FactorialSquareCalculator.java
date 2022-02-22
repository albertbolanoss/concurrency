import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class FactorialSquareCalculator extends RecursiveTask<Integer> {

    private Integer n;

    public FactorialSquareCalculator(Integer n) {
        this.n = n;
    }

    @Override
    protected Integer compute() {
        if (n <= 1) {
            return n;
        }

        FactorialSquareCalculator calculator = new FactorialSquareCalculator(n - 1);
        calculator.fork();

        return n * n + calculator.join();
    }

    public static void main(String[] args) {
        FactorialSquareCalculator factorialSquareCalculator = new FactorialSquareCalculator(9);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.execute(factorialSquareCalculator);
    }
}
