public class ArrayParameter {
    public static void main(String[] args) {
        double[] myList = {1.9, 2.9, 3.4, 3.5};
 
        // 打印所有数组元素
        printArray(myList);
        //反转数组
        double[] myReverseList = reverse(myList);
        printArray(myReverseList);
    }

    public static void printArray(double[] array) {
        System.out.print("==Start==: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
        System.out.println("==End==");
    }

    public static double[] reverse(double[] list) {
        double[] result = new double[list.length];
        for (int i = 0, j = result.length - 1; i < list.length; i++, j--) {
            result[j] = list[i];
        }
        return result;
    }
}