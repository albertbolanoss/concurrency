import java.math.BigInteger;

public class BigComputationMain {

    public static void main(String[] args) {
        Thread thread = new LongComputationTask(new BigInteger("20000000"), new BigInteger("10000000000000"));
        thread.start();
        thread.interrupt();
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
                if (this.isInterrupted()) {
                    System.out.println("Premature interrupted computation");
                    return BigInteger.ZERO;
                }

                result = result.multiply(base);
            }

            return result;
        }
    }
}
