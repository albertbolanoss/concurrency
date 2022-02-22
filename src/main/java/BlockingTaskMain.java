public class BlockingTaskMain {
    public static void main(String[] args) {
        BlockingTask blockingTask = new BlockingTask();
        blockingTask.start();
        blockingTask.interrupt();
    }

    public static class BlockingTask extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(500000000);
            } catch (InterruptedException interruptedException) {
                System.out.println("interrupted");
            }
        }
    }
}
