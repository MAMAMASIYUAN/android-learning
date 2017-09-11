import java.io.*;

public class StreamDemo {
    private static String fileName = "hello.txt";
    private static String newFileName = "newfile.txt";
    public static void main(String args[]) {
        try {
            // ReadByStream();
            //ReadByByte();
            // ConvertUpperCaseToLowerCase();
            //WriteWithString();
            //CopyFile();
            ConvertUpperCaseToLowerCase();
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    // ==================== Read =============================
    private static void ReadByStream() throws IOException {
        File f = new File(fileName);
        InputStream in = new FileInputStream(f);
        byte[] b = new byte[(int) f.length()]; 
        in.read(b);
        System.err.println("长度为=" + f.length()); 
        in.close();
        System.err.println(new String(b));
        in.close();
    }

    private static void ReadByByte() throws IOException {
        File f = new File(fileName);
        InputStream in = new FileInputStream(f);
        byte[] b = new byte[(int) f.length()];
        for (int i = 0; i < b.length; i++) {
            b[i] = (byte) in.read();
        } 
        in.close();
        System.err.println(new String(b));
    }

    private static void ReadByEndFlag() throws IOException {
        File f = new File(fileName);
        InputStream in = new FileInputStream(f);
        byte[] b = new byte[1024];
        int count = 0;
        int temp = 0;
        while ((temp = in.read()) != (-1)) {
            b[count++] = (byte) temp;
        } 
        in.close();
        System.err.println(new String(b));
    }

    // ==================== Write =============================
    private static void WriteWithString() throws IOException {
        File f = new File(newFileName);
        OutputStream os = new FileOutputStream(f);
        String str = "This is a new file.";
        byte[] b = str.getBytes();
        os.write(b);
        os.close();
    }

    private static void WriteWithStream() throws IOException {
        File f = new File(newFileName);
        OutputStream out = new FileOutputStream(f);
        String str = "Hello World";
        byte[] b = str.getBytes();
        for (int i = 0; i < b.length; i++) {
            out.write(b[i]);
        }
        out.close();
    }
    private static void WriteWithAppendStream() throws IOException {
        File f = new File(newFileName);
        OutputStream out = new FileOutputStream(f, true); //true表示追加模式，否则为覆盖
        String str = "Android";
        //String str="\r\nAndroid"; 可以换行
        byte[] b = str.getBytes();
        for (int i = 0; i < b.length; i++) {
            out.write(b[i]);
        }
        out.close();
    }

    private static void CopyFile() throws IOException {
        File file1 = new File("hello.txt");
        File file2 = new File("hello-copy.txt");

        if (!file1.exists()) {
            System.out.println("被复制的文件不存在");
            return;
        }
        InputStream input = new FileInputStream(file1);
        OutputStream output = new FileOutputStream(file2);
        if ((input != null) && (output != null)) {
            int temp = 0;
            while ((temp = input.read()) != (-1)) {
                output.write(temp);
            }
        }
        input.close();
        output.close();
    }
    private static void ConvertUpperCaseToLowerCase() throws IOException {
        String str = "ANDROID";
        ByteArrayInputStream input = new ByteArrayInputStream(str.getBytes());
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        int temp = 0;
        while ((temp = input.read()) != -1) {
            char ch = (char) temp;
            output.write(Character.toLowerCase(ch));
        }
        String outStr = output.toString();
        input.close();
        output.close();
        System.out.println(outStr);
    }
}