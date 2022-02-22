public class ExceptionThreadMain {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("We are now in the threat " + Thread.currentThread().getName());
            System.out.println("Priority " + Thread.currentThread().getPriority());
        });

        thread.setName("New Worker Thread");
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("Error " + t.getName() + "\n" + e);
            }
        });

        thread.start();

    }
}
