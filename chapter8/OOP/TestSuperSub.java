class SuperClass {
  private int n;
  SuperClass(){
    System.out.println("1. 父类无参数构造器");
  }
  SuperClass(int n) {
    System.out.println("2. 父类带参数构造器");
    this.n = n;
  }
}
class SubClass extends SuperClass{
  private int n;
  
  SubClass(){
    super(300);
    System.out.println("3. 子类无参数构造器");
  }  
  
  public SubClass(int n){
    // 并没有Call Super
    System.out.println("4. 子类带参数构造器:" + n);
    this.n = n;
  }
}
public class TestSuperSub{
  public static void main (String args[]){
    SubClass sc = new SubClass();
    SubClass sc2 = new SubClass(200); 
  }
}