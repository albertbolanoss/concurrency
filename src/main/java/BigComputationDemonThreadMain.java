import java.math.BigInteger;

public class BigComputationDemonThreadMain {

    public static void main(String[] args) {
        Thread thread = new LongComputationTask(new BigInteger("2000"), new BigInteger("1000"));
        thread.setDaemon(true);
        thread.start();

    }

    private static class LongComputationTask extends Thread {
        private BigInteger base;
        private BigInteger power;

        public LongComputationTask(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
            System.out.println("Result: " + pow(this.base, this.power));
        }


        private BigInteger pow(BigInteger base, BigInteger power) {
            BigInteger result = BigInteger.ONE;
            for (BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i = i.add(BigInteger.ONE) ) {
                result = result.multiply(base);
            }

            return result;
        }
    }
}
