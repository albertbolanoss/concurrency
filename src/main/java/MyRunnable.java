import java.math.BigInteger;

public class MyRunnable implements Runnable {

    @Override
    public void run() {

        int total = 0;
        for(int i=0;i<5;i++) {

            total+=i;
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


        }
        System.out.println(Thread.currentThread().getName());
        System.out.println(total);
    }

    public static void main(String[] args) {
        MyRunnable t= new MyRunnable();
        Thread hilo= new Thread(t);
        hilo.start();

        BigInteger result = new BigInteger("1");
        result = result.multiply(new BigInteger("2")).pow(new BigInteger("2").intValue());

        System.out.println(" => " +result.intValue());
    }

}