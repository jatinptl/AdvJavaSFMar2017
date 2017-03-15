package runnables;

class MyJob implements Runnable {
  private int i = 0;
  @Override
  public void run() {
    for (; i < 10_000; i++) {
      System.out.println(Thread.currentThread().getName() + " i is " + i);
    }
  }
}

public class SimpleRunnableOne {
  public static void main(String[] args) {
    Runnable r = new MyJob();
    System.out.println("About to start job");
    Thread t = new Thread(r);
    Thread t1 = new Thread(r);
//    t.setDaemon(true);
    t.start();
    t1.start();
    System.out.println("Main finished");
  }
}
