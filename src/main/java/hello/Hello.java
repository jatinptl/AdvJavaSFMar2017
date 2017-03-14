package hello;

import java.util.function.Predicate;

class X {

    public int length() {
        return 3;
    }
}
interface Criterion<E> {

    boolean test(E s);
}

public class Hello {

    public static void doStuff(Predicate<String> px) {
        System.out.println("Predicate...");
    }
    public static void doStuff(Criterion<String> px) {
        System.out.println("Criterion...");
    }
    
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        String s1 = "Hello";
        String s2 = "Hello";
        String s3 = new String("Hello");
        s3 = s3.intern(); // Flyweight 

        System.out.println("s1 == s2 " + (s1 == s2));
        System.out.println("s1 == s3 " + (s1 == s3));

        Criterion<String> ps = (s -> s.length() > 3);
        boolean b = ps.test("Banana");

        doStuff(ps);
        // INSUFFICIENT CONTEXT, cannot work
//        doStuff(x -> x.length() > 3);
    }
}
