import java.io.*;

public class ExceptionDemo{
 
   public static void main(String args[]){
      try {
         int x = 100, y = 10;
         System.out.println("除法 : " + x / y);
      } catch (ArithmeticException e2){
         //System.out.println("发生数学运算异常 : " + e2);
         e2.printStackTrace();
      }
      System.out.println("执行完毕！");
   }
}