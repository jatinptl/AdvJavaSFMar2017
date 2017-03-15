package dynamicjava;

//@RunMe
public class IntrospectMe implements Stuffer {
//  @RunMe
  private int value;
  @SetMe
  private String name;

  @RunMe
  public void doStuff() {
    System.out.println(this.toString());
  }
  
  @Override
  public String toString() {
    return "IntrospectMe{" + "value=" + value + ", name=" + name + '}';
  }
}
