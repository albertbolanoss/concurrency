package racecondition;

public class MutationRunnable implements Runnable {
  private int value;

  public MutationRunnable(int value) {
    this.value = value;
  }

  @Override
  public void run() {
    for (int i = 0; i < 50; i++) {
      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      value++;
    }
  }

  public int getValue() {
    return value;
  }
}
