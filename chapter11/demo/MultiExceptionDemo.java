import java.io.*;

public class MultiExceptionDemo{
 
   public static void main(String args[]){
      try {
          // 声明只有两个元素的数组
         int a[] = new int[2];
         // 如果不小心访问第三个元素？
         System.out.println("访问第2个元素 : " + a[3]);

         int x = 100, y = 0;
         System.out.println("除法 : " + x / y);

         String s = null;;
         System.out.println("访问空对象 : " + s.toString());
      } catch(ArrayIndexOutOfBoundsException e1){
         System.out.println("发生数组越界异常 : " + e1);
      } catch(ArithmeticException e2){
         System.out.println("发生数学运算异常 : " + e2);
      } catch(NullPointerException e3){
         System.out.println("发生空指针异常 : " + e3);
      }

      System.out.println("执行完毕！");
   }
}
