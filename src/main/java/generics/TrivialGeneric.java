package generics;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TrivialGeneric {
    
    public static void oldMethod(List l) {
        l.add(0, LocalDateTime.now());
    }
    
    public static void main(String[] args) {
        List<String> l = new ArrayList();
        l.add("Hello");
        l.add("Goodbye");
//        l.add(LocalDateTime.now());
        
        oldMethod(l);
        // runtime DOES HAVE a cast
        // therefore fails cleanly and predictably at runtime
        String s = l.get(0);
        
    }
}
