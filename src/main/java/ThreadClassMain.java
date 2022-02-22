public class ThreadClassMain {

    public static void main(String[] args) {
        Thread thread = new Thread(new  NewThread());
        thread.start();
    }

    private static class NewThread extends Thread {
        @Override
        public void run() {
            System.out.println("We are now in the threat " + this.getName());
            System.out.println("Priority " + this.getPriority());
        }
    }
}
