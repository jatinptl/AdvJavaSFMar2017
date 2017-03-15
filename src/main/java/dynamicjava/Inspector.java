package dynamicjava;

import java.beans.Introspector;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


class MyLoggerProxy implements InvocationHandler {
  private Stuffer target;
  public MyLoggerProxy(Stuffer target) {
    this.target = target;
  }
  
  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    System.out.println("Logging a call to " + method);
    Object rv = method.invoke(target, args);
    System.out.println("Call returned " + rv);
    return rv;
  }
}

public class Inspector {

  public static void main(String[] args) throws Throwable {
    Class cl = Class.forName("dynamicjava.IntrospectMe");
//    Method [] methods = cl.getDeclaredMethods();
    Object obj = cl.newInstance();
    
    MyLoggerProxy proxy = new MyLoggerProxy((Stuffer)obj);
    Stuffer p = (Stuffer)Proxy.newProxyInstance(cl.getClassLoader(), 
        new Class[]{Stuffer.class}, proxy);

//    Field [] fields = cl.getFields(); // includes parent stuff, but only the accessible parts
    Field[] fields = cl.getDeclaredFields(); // no parent stuff, but includes private
    for (Field f : fields) {
      System.out.println(">> " + f);
      SetMe annot = f.getAnnotation(SetMe.class);
      if (annot != null) {
        System.out.println("*** ANNOTATED!!!!");
        f.setAccessible(true);
        f.set(obj, "Set by annotation!");
      }
    }

    Method[] methods = cl.getMethods();
    for (Method m : methods) {
      System.out.println("> " + m);
      RunMe annot = m.getAnnotation(RunMe.class);
      if (annot != null) {
        System.out.println("**** ANNOTATED!!!!");
        m.invoke(obj);
      }
    }

    Method m = cl.getMethod("toString");
    System.out.println(">>> " + m);
    
    p.doStuff();
  }
}
