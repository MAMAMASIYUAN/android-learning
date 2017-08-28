import java.util.*;
  
public class DiffDemo {
 
   public static void main(String args[]) {
      try {
         long start = System.currentTimeMillis( );
         System.out.println("Start =====" + new Date( ) + "\n");
         // 模仿一个长时间的操作
         Thread.sleep(5*60*10);
         long end = System.currentTimeMillis( );
         System.out.println("End =====" + new Date( ) + "\n");
         long diff = end - start;
         System.out.println("执行时长 : " + diff + "毫秒");
      } catch (Exception e) {
          System.out.println("Sleep异常：");
          e.printStackTrace(); 
      }
   }
}