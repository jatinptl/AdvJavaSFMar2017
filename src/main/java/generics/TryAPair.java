package generics;

import java.time.LocalDateTime;

public class TryAPair {
    public static void main(String[] args) {
        Pair<String> x = new Pair<>("Hello", "String");
        
        String y = x.getLeft();
    }
}
