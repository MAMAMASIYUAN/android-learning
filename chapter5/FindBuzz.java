public class FindBuzz {
    public static void main(String[] args) {
        fizzBuzz(100);
    }
    public static void fizzBuzz(int n) {
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                System.out.println(i + "是15的倍数");
            } else if (i % 5 == 0) {
                System.out.println(i + "是5的倍数");
            } else if (i % 3 == 0) {
                System.out.println(i + "是3的倍数");
            } else {
                //System.out.println(i + "不是15，5，3的倍数");
            }
        }
    }
}