import java.io.*;

public class MultiExceptionDemo{
 
   public static void main(String args[]){
      try {
          // ����ֻ������Ԫ�ص�����
         int a[] = new int[2];
         // �����С�ķ��ʵ�����Ԫ�أ�
         System.out.println("���ʵ�2��Ԫ�� : " + a[3]);

         int x = 100, y = 0;
         System.out.println("���� : " + x / y);

         String s = null;;
         System.out.println("���ʿն��� : " + s.toString());
      } catch(ArrayIndexOutOfBoundsException e1){
         System.out.println("��������Խ���쳣 : " + e1);
      } catch(ArithmeticException e2){
         System.out.println("������ѧ�����쳣 : " + e2);
      } catch(NullPointerException e3){
         System.out.println("������ָ���쳣 : " + e3);
      }

      System.out.println("ִ����ϣ�");
   }
}
