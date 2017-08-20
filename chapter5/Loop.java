public class Loop {

    public static void main(String[] args) {
        whileLoop();
        doWhileLoop();
        forLoop();
    }

    private static void whileLoop() {
        int x = 10;
        while (x < 20) {
            System.out.println("whileLoop, x的值是: " + x);
            x++;
        }
    }

    private static void doWhileLoop() {
        int x = 20;
        do {
            System.out.println("doWhileLoop, x的值是: " + x);
            x++;
        } while (x < 30);
    }

    private static void forLoop() {
        for (int x = 30; x < 40; x = x + 1) {
            System.out.println("forLoop, x的值是: " + x);
        }
    }
}