package except;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Stream;

interface ExceptionFunction<T,R>  {
  R apply(T t) throws Exception;
}

public class ExceptionInStream {
  public static Stream<String> openFile(String fname) throws IOException {
    return Files.lines(Paths.get(fname));
  }
  
  public static <T, R> Function<T, Optional<R>> hideException(ExceptionFunction<T,R> e) {
    return x -> {
      try {
        return Optional.of(e.apply(x));
      } catch (Throwable t) {
        System.out.println("Something broke!");
        return Optional.empty();
      }
    };
  }
  
  public static void main(String[] args) {
    final Pattern WORD_BREAK = Pattern.compile("\\W+");
    
    Stream.of("a.txt", "b.txt", "c.txt")
        .map(hideException(ExceptionInStream::openFile))
        .filter(Optional::isPresent)
        .flatMap(Optional::get)
        .flatMap(WORD_BREAK::splitAsStream)
        .forEach(System.out::println);
  }
}
