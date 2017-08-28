
public class ArrayHandle {
    public static void main(String[] args) {
      double[] myList = {1.9, 2.9, 3.4, 3.5};
      
      // 打印所有数组元素
      for (int i = 0; i < myList.length; i++) {
         System.out.println(myList[i] + " ");
      }
      // 计算所有元素的总和
      double total = 0;
      for (int i = 0; i < myList.length; i++) {
         total += myList[i];
      }
      System.out.println("总和是 " + total);
      // 查找最大元素
      double max = myList[0];
      double min = myList[0];
      for (int i = 1; i < myList.length; i++) {
        //  if (myList[i] > max) {
        //      max = myList[i];
        //  }
        //  if (myList[i] < min) {
        //      min = myList[i];
        //  }
        max = Math.max(max, myList[i]);
        min = Math.min(min, myList[i]);
      }
      System.out.println("最大值是 " + max);
      System.out.println("最小值是 " + min);
   }
}