public class BasicThreadMain {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("We are now in the threat " + Thread.currentThread().getName());
            System.out.println("Priority " + Thread.currentThread().getPriority());
        });

        Thread secondThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("I am a callable");
            }
        });

        thread.setName("New Worker Thread");
        thread.setPriority(Thread.MIN_PRIORITY);

        System.out.println("Before We are now in the threat " + Thread.currentThread().getName());
        thread.start();
        System.out.println("After We are now in the threat " + Thread.currentThread().getName());

        Thread.sleep(10000);
    }
}
