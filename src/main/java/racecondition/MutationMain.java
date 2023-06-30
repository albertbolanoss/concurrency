package racecondition;

public class MutationMain {
  public static void main(String[] args) throws InterruptedException {
    MutationRunnable threadIncrementer = new MutationRunnable(1);
    Thread t1 = new Thread(threadIncrementer);
    Thread t2 = new Thread(threadIncrementer);
    Thread t3 = new Thread(threadIncrementer);
    t1.start();
    t2.start();
    t3.start();

    t1.join();
    t2.join();
    t3.join();
    System.out.println(threadIncrementer.getValue());

  }
}
