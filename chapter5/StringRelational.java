public class StringRelational {

    public static void main(String[] args) {
        String a = "a";
        String b = "a";
        String c = new String("a");
        String d = new String("a");
        System.out.println("a和b相同 = " + (a == b));
        System.out.println("a和b相同 = " + (a.equals(b)));
        System.out.println("c和d相同 = " + (c == d));
        System.out.println("c和d相同 = " + (c.equals(d)));
    }
}