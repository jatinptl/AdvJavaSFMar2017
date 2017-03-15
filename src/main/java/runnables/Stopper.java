package runnables;

class StopMe implements Runnable {
  private boolean stop;
  
  @Override
  public void run() {
    while (! stop) {
    }   
    System.out.println("Stopping...");
  }
  
  public void stop() {
    stop = true;
  }
}
  
public class Stopper {
  public static void main(String[] args) throws InterruptedException {
    StopMe s = new StopMe();
    new Thread(s).start();
    Thread.sleep(1500);
    s.stop();
    System.out.println("Stop called");
  }
}
