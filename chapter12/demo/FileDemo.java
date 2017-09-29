import java.io.*;

public class FileDemo {
    public static void main(String args[]) {
      writeFileWithByte();
      try {
        writeFileWithEncoding();
      } catch (IOException e) {
            System.out.print("Exception");
      }
    }

    private static void writeFileWithByte() {
        try {
            byte bWrite[] = {
                65,
                67,
                69,
                71,
                73
            };
            OutputStream os = new FileOutputStream("test.txt");
            for (int x = 0; x < bWrite.length; x++) {
                os.write(bWrite[x]); // writes the bytes
            }
            os.close();

            InputStream is = new FileInputStream("test.txt");
            int size = is.available();

            for (int i = 0; i < size; i++) {
                System.out.print((char) is.read() + "  ");
            }
            is.close();
        } catch (IOException e) {
            System.out.print("Exception");
        }
    }

    public static void writeFileWithEncoding() throws IOException {

        File f = new File("a.txt");
        FileOutputStream fop = new FileOutputStream(f);
        // ����FileOutputStream����,�ļ������ڻ��Զ��½�

        OutputStreamWriter writer = new OutputStreamWriter(fop, "UTF-8");
        // ����OutputStreamWriter����,��������ָ������,Ĭ��Ϊ����ϵͳĬ�ϱ���,windows��gbk��

        writer.append("��������");
        // д�뵽������

        writer.append("\r\n");
        //����

        writer.append("English");
        // ˢ�»����,д�뵽�ļ�,��������Ѿ�û��д���������,ֱ��closeҲ��д��

        writer.close();
        //�ر�д����,ͬʱ��ѻ���������д���ļ�,���������ע�͵�

        fop.close();
        // �ر������,�ͷ�ϵͳ��Դ

        FileInputStream fip = new FileInputStream(f);
        // ����FileInputStream����

        InputStreamReader reader = new InputStreamReader(fip, "UTF-8");
        // ����InputStreamReader����,������д����ͬ

        StringBuffer sb = new StringBuffer();
        while (reader.ready()) {
            sb.append((char) reader.read());
            // ת��char�ӵ�StringBuffer������
        }
        System.out.println(sb.toString());
        reader.close();
        // �رն�ȡ��

        fip.close();
        // �ر�������,�ͷ�ϵͳ��Դ
    }
}