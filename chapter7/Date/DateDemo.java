import java.util.*;
import java.text.*;
 
  
public class DateDemo {
   public static void main(String args[]) {
        // ��ʼ�� Date ����
        Date date = new Date();
        
        // ʹ�� toString() ������ʾ����ʱ��
        System.out.println(date.toString());

        printSimpleFormat();

        printfDate();
    }

    private static void printSimpleFormat() {
        Date dNow = new Date();
        /*
        ��һ�д���ȷ����ת���ĸ�ʽ������ yyyy �������Ĺ�Ԫ�꣬MM ���·ݣ�dd �����ڣ�HH:mm:ss ��ʱ���֡��롣
        ע��:�еĸ�ʽ��д���еĸ�ʽСд������ MM ���·ݣ�mm �Ƿ֣�HH �� 24 Сʱ�ƣ��� hh �� 12 Сʱ�ơ�
        */
        SimpleDateFormat ft = new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz"); 
        System.out.println("��ǰʱ��: " + ft.format(dNow));
    }

    private static void printfDate() {
        // ��ʼ�� Date ����
        Date date = new Date();
    
        //c��ʹ��  
        System.out.printf("ȫ�����ں�ʱ����Ϣ��%tc%n",date);          
        //f��ʹ��  
        System.out.printf("��-��-�ո�ʽ��%tF%n",date);  
        //d��ʹ��  
        System.out.printf("��/��/���ʽ��%tD%n",date);  
        //r��ʹ��  
        System.out.printf("HH:MM:SS PM��ʽ��12ʱ�ƣ���%tr%n",date);  
        //t��ʹ��  
        System.out.printf("HH:MM:SS��ʽ��24ʱ�ƣ���%tT%n",date);  
        //R��ʹ��  
        System.out.printf("HH:MM��ʽ��24ʱ�ƣ���%tR",date);  
    }
}
