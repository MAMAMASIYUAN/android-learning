import java.util.*;
import java.text.*;

public class CalendarDemo {
   public static void main(String args[]) {
        Calendar c1 = Calendar.getInstance();
        // ������
        int year = c1.get(Calendar.YEAR);
        // ����·�
        int month = c1.get(Calendar.MONTH) + 1;
        // �������
        int date = c1.get(Calendar.DATE);
        // ���Сʱ
        int hour = c1.get(Calendar.HOUR_OF_DAY);
        // ��÷���
        int minute = c1.get(Calendar.MINUTE);
        // �����
        int second = c1.get(Calendar.SECOND);
        // ������ڼ���ע�⣨�����Date���ǲ�ͬ�ģ���1���������ա�2��������1��3�������ڶ����Դ����ƣ�
        int day = c1.get(Calendar.DAY_OF_WEEK);

        System.out.println(year + ":" + month+ ":"
                            +date + ":" + hour+ ":"
                            +minute + ":" + second+ ":"
                            +day);
   }
}