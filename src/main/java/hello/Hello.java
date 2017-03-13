package hello;

public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        
        String s1 = "Hello";
        String s2 = "Hello";
        String s3 = new String("Hello");
        s3 = s3.intern(); // Flyweight 
        
        System.out.println("s1 == s2 " + (s1 == s2));
        System.out.println("s1 == s3 " + (s1 == s3));
    }
}
