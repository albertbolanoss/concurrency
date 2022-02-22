import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class VaultMain {
    public static final int MAX_PASSWORD = 9999;
    public static void main(String[] args) {
        Random random = new Random();
        Vault vault = new Vault(random.nextInt(MAX_PASSWORD));
        List<Thread> threads = Arrays.asList(
            new Thread(new SpendTimeThread()),
            new AscendingHackerThread(vault),
            new DecendingHackerThread(vault),
            new PoliceThread()
        );


        for(Thread thread : threads) {
            thread.start();
        }
    }

    private static class Vault {
        private int password;

        public Vault(Integer password) {
            this.password = password;
        }

        public boolean isCorrectPassword(int guess) throws InterruptedException {
            Thread.sleep(5);
            return this.password == guess;
        }
    }

    private static abstract class HackerThread extends Thread {
        protected Vault vault;

        public HackerThread(Vault vault) {
            this.vault = vault;
            this.setName(this.getClass().getSimpleName());
            this.setPriority(Thread.MAX_PRIORITY);
        }

        @Override
        public void run() {
            System.out.println("Starting thread " + this.getName());
            super.run();
        }
    }

    private static class AscendingHackerThread extends HackerThread {

        public AscendingHackerThread(Vault vault) {
            super(vault);
        }

        @Override
        public void run() {
            for(int guess = 0; guess< MAX_PASSWORD; guess++) {
                try {
                    if (vault.isCorrectPassword(guess)) {
                        System.out.println(this.getName() + " guessed the password");
                        System.exit(0);
                    }
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
        }
    }

    private static class DecendingHackerThread extends HackerThread {

        public DecendingHackerThread(Vault vault) {
            super(vault);
        }

        @Override
        public void run() {
            for(int guess = MAX_PASSWORD; guess >= 0; guess--) {
                try {
                    if (vault.isCorrectPassword(guess)) {
                        System.out.println(this.getName() + " guessed the password");
                        System.exit(0);
                    }
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
        }
    }

    private static class PoliceThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++ ) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }

            System.out.println("Game over for you hackers");
            System.exit(0);
        }
    }

    private static class SpendTimeThread implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++ ) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                System.out.println("Second " + i);
            }
        }
    }
}
