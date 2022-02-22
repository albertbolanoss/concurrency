import java.math.BigInteger;

public class ComplexCalculation {
    public static void main(String[] args) throws InterruptedException {
        ComplexCalculation complexCalculation = new ComplexCalculation();
        BigInteger result = complexCalculation.calculateResult(
                new BigInteger("2"),
                new BigInteger("2"),
                new BigInteger("3"),
                new BigInteger("2")
        );

        System.out.println("Result: " + result);
    }

    public BigInteger calculateResult(BigInteger base1, BigInteger power1, BigInteger base2, BigInteger power2) {
            PowerCalculatingThread thread1 = new PowerCalculatingThread(base1, power1);
            PowerCalculatingThread thread2 = new PowerCalculatingThread(base2, power2);

            thread1.start();
            thread2.start();

            try {
                thread1.join();
                thread2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return thread1.getResult().add(thread2.getResult());
    }

    private static class PowerCalculatingThread extends Thread {
        private BigInteger result = BigInteger.ONE;
        private BigInteger base;
        private BigInteger power;

        public PowerCalculatingThread(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
            for(BigInteger i = BigInteger.ZERO;
                i.compareTo(power) !=0;
                i = i.add(BigInteger.ONE)) {
                result = result.multiply(base);
            }
            System.out.println(String.format("%s Pow %s = %s", base, power, result));
        }

        public BigInteger getResult() { return result; }
    }
}