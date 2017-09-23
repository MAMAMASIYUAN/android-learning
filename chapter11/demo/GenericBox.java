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
    GenericBox<Boolean> objBox = new GenericBox<>();
 
    integerBox.add(new Integer(10));
    stringBox.add(new String("23"));
    
    

    System.out.printf("����ֵΪ :%d\n\n", integerBox.get());
    System.out.printf("�ַ���Ϊ :%s\n", stringBox.get());
  }
}