public class StringBufferDemo {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("a")
                    .append("b")
                    .append("c")
                    .append("d")
                    .append("e")
                    .append("f");
        System.out.println(stringBuffer.toString());
        
        System.out.println(stringBuffer.reverse().toString());

        stringBuffer.delete(1, 3);
        System.out.println(stringBuffer.toString());
        
        stringBuffer.insert(1, 65);
        System.out.println(stringBuffer.toString());
        
        stringBuffer.replace(1, 3, "cd");
        System.out.println(stringBuffer.toString());
    }
}