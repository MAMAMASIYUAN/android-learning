public class ArraysClass {
    public static void main(String[] args) {
        int[] myList = {5, 8, 6, 4, 1, 2, 3, 9, 0, 7};
        int[] myListCopy = {5, 8, 6, 4, 1, 2, 3, 9, 0, 7};
        // ��ӡ��������Ԫ��
        printArray(myList);
        // �Ƚ�1
        System.out.println("�Ƚ�1:" + java.util.Arrays.equals(myList, myListCopy));
        // ����
        java.util.Arrays.sort(myList);
        // �Ƚ�2
        System.out.println("�Ƚ�2:" + java.util.Arrays.equals(myList, myListCopy));
        // ��ӡ��������Ԫ��
        printArray(myList);
        // ���ֲ���
        System.out.println(java.util.Arrays.binarySearch(myList, 6));
        // ������������ڣ� - (����� + 1)
        System.out.println(java.util.Arrays.binarySearch(myList, 10));
        // ���
        java.util.Arrays.fill(myList, 0);
        // ��ӡ��������Ԫ��
        printArray(myList);
    }

    public static void printArray(int[] array) {
        System.out.print("==��ʼ==: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
        System.out.println("==����==");
    }
}