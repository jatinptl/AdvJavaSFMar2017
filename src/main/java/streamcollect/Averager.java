package streamcollect;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

class AverageCollector {

  private double sum;
  private int count;

  public void include(double d) {
    sum += d;
    count++;
  }

  public void merge(AverageCollector other) {
    this.sum += other.sum;
    this.count += other.count;
  }

  public double getMean() {
    return sum / count;
  }
}

public class Averager {

  public static void main(String[] args) {
    long start = System.nanoTime();
    System.out.println("Mean is "
        + Stream.generate(() -> ThreadLocalRandom.current().nextDouble(-Math.PI, Math.PI))
            .parallel()
            .limit(100_000_000)
            .map(Math::sin)
            .collect(AverageCollector::new, AverageCollector::include, AverageCollector::merge)
            .getMean()
    );
    long end = System.nanoTime();
    System.out.println("Time is " + ((end - start) / 1_000_000_000.0));
  }
}
