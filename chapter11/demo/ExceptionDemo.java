import java.io.*;

public class ExceptionDemo{
 
   public static void main(String args[]){
      try {
         int x = 100, y = 10;
         System.out.println("���� : " + x / y);
      } catch (ArithmeticException e2){
        //  System.out.println("������ѧ�����쳣 : " + e2);
         e2.printStackTrace();
      }
      System.out.println("ִ����ϣ�");
   }
}