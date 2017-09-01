public class ArraySort {
    public static void main(String[] args) {

      int size = 10;
      double temp;

      double[] myList = new double[size];
      myList[0] = 5.6;
      myList[1] = 4.5;
      myList[2] = 3.3;
      myList[3] = 13.2;
      myList[4] = 4.0;
      myList[5] = 34.33;
      myList[6] = 34.0;
      myList[7] = 45.45;
      myList[8] = 99.993;
      myList[9] = 11123;
      for (int i = size - 1; i > 0; i--) {
         for (int j = 0; j < i; j++){
           if (myList[j] > myList[j + 1]){
             temp = myList[j];
             myList[j] = myList[j + 1];
             myList[j + 1] = temp;
         }
      }
      System.out.println(myList[size - i]);
   }
  } 
}
