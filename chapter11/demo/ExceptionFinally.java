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
         System.out.println("������ѧ�����쳣 : " + e);
         result = 5;
         return result;
      } finally{
        System.out.println("Finallyִ����ϣ�");
        // result = 10;
        // return result;
      }
      return result;
   }
}
