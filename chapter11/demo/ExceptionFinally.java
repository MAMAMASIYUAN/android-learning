public class ExceptionFinally{
  public static void main(String args[]){
      System.out.println(getDivValue());
   }

   private static int getDivValue() {
       int x = 100, y = 2;
       int result = 0;
       try {
           result = x / y;
          //  return result;
       }catch(ArithmeticException e){
         System.out.println("发生数学运算异常 : " + e);
         result = 5;
         return result;
      } finally{
        System.out.println("Finally执行完毕！");
        // result = 10;
        // return result;
      }
      return result;
   }
}
