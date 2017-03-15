package prodcons;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProdCons {

  public static void main(String[] args) {
    System.out.println("Starting...");
    BlockingQueue<Integer> q = new ArrayBlockingQueue<>(10);
    final int LIMIT = 1_000;
    final int NPRODS = 4;

    class Producer implements Runnable {

      @Override
      public void run() {
        for (int i = 0; i < LIMIT; i++) {
          Integer data = new Integer(i);
          try {
            q.put(data);
            if (i < 100) {
              Thread.sleep(1);
            }
            data = null;
          } catch (InterruptedException ex) {
            break;
          }
        }
      }
    }

    class Consumer implements Runnable {

      @Override
      public void run() {
        int[] counts = new int[LIMIT];
        while (true) {
          try {
            counts[q.take()]++; // SINGLE CONSUMER!
          } catch (InterruptedException ex) {
            break;
          }
        }
        for (int i = 0; i < counts.length; i++) {
          if (counts[i] != NPRODS) {
            System.out.println("ERROR, number " + i
                + " seen " + counts[i] + " times!");
          }
        }
        System.out.println("Consumer exiting...");
      }
    }

    Runnable prod = new Producer();
    Runnable cons = new Consumer();
    Thread[] threads = new Thread[NPRODS];
    for (int i = 0; i < NPRODS; i++) {
      System.out.println("Starting producer " + i);
      threads[i] = new Thread(prod);
      threads[i].start();
    }
    Thread consThread = new Thread(cons);
    consThread.start();

    for (int i = 0; i < NPRODS; i++) {
      try {
        threads[i].join();
      } catch (InterruptedException ex) {
        System.out.println("Yikes, join was interrupted!!!");
      }
    }
    consThread.interrupt();
    System.out.println("Main exiting...");
  }
}
