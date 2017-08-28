public class ArraysClass {
    public static void main(String[] args) {
        int[] myList = {5, 8, 6, 4, 1, 2, 3, 9, 0, 7};
        int[] myListCopy = {5, 8, 6, 4, 1, 2, 3, 9, 0, 7};
        // 打印所有数组元素
        printArray(myList);
        // 比较1
        System.out.println("比较1:" + java.util.Arrays.equals(myList, myListCopy));
        // 排序
        java.util.Arrays.sort(myList);
        // 比较2
        System.out.println("比较2:" + java.util.Arrays.equals(myList, myListCopy));
        // 打印所有数组元素
        printArray(myList);
        // 二分查找
        System.out.println(java.util.Arrays.binarySearch(myList, 6));
        // 二分如果不存在？ - (插入点 + 1)
        System.out.println(java.util.Arrays.binarySearch(myList, 10));
        // 填充
        java.util.Arrays.fill(myList, 0);
        // 打印所有数组元素
        printArray(myList);
    }

    public static void printArray(int[] array) {
        System.out.print("==开始==: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
        System.out.println("==结束==");
    }
}