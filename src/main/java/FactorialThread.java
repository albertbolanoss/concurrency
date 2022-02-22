import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FactorialThread extends Thread {
    private Long inputNumber;
    private Boolean isFinish;
    private BigInteger result;

    public FactorialThread(Long inputNumber) {
        this.inputNumber = inputNumber;
        this.isFinish = false;
    }

    @Override
    public void run() {
        this.result = factorial(this.inputNumber);
        this.isFinish = true;
    }

    public BigInteger factorial(Long n) {
        BigInteger tempResult = BigInteger.ONE;

        for (Long i = n; i > 0; i--) {
            tempResult = tempResult.multiply(new BigInteger(Long.toString(i)));
        }

        return tempResult;
    }

    public Long getInputNumber() {
        return inputNumber;
    }

    public Boolean getFinish() {
        return isFinish;
    }

    public BigInteger getResult() {
        return result;
    }

    public static void main(String[] args) throws InterruptedException {
        List<Long> inputNumbers = Arrays.asList(0L, 3435L, 2324L, 23L, 5556L);
        List<Thread> threads = inputNumbers.stream().map(FactorialThread::new).collect(Collectors.toList());


        for (Thread thread : threads) {
            thread.start();
        }

//        for (Thread thread : threads) {
//            thread.join();
//        }

        for (Thread thread : threads) {
            FactorialThread factorialThread = (FactorialThread) thread;
            if (factorialThread.isFinish) {
                System.out.println(factorialThread.getResult());
            } else {
                System.out.println("Processing");
            }
        }

    }
}
