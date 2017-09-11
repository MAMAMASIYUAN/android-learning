public class GenericBox<T, E, S> {
   
  private T t;
  private E e;
  private S s;
 
  public void add(T t) {
    this.t = t;
  }
 
  public T get() {
    return t;
  }
 
  public static void main(String[] args) {
    GenericBox<Integer, String, Boolean> integerBox = new GenericBox<>();
    GenericBox<String> stringBox = new GenericBox<>();
    GenericBox<Object> objBox = new GenericBox<>();
 
    integerBox.add(new Integer(10));
    stringBox.add(new String("新生大学·"));
    
    

    System.out.printf("整型值为 :%d\n\n", integerBox.get());
    System.out.printf("字符串为 :%s\n", stringBox.get());
  }
}