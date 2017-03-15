package concordance;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Concordance {

  public static void main(String[] args) throws Throwable {
    final Pattern WORD_BREAK = Pattern.compile("\\W+");
    try (Stream<String> in = Files.lines(Paths.get("PrideAndPrejudice.txt"))) {
      in          
          .map(String::toLowerCase)
//          .flatMap(s->Arrays.stream(s.split("\\W+")))
//          .flatMap(s->Stream.of(s.split("\\W+")))
          .flatMap(WORD_BREAK::splitAsStream)
          .filter(s -> s.length() > 0)
//          s->s
          .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
//          .forEach((k,v) -> System.out.println(k + " : " + v));
          .entrySet().stream()
//          .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
          .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
          .limit(200)
          .forEachOrdered(e -> System.out.printf(
          "%20s occurs %5d times\n", e.getKey(), e.getValue()));
    }
  }
}
