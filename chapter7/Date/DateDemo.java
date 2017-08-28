import java.util.*;
import java.text.*;
 
  
public class DateDemo {
   public static void main(String args[]) {
        // 初始化 Date 对象
        Date date = new Date();
        
        // 使用 toString() 函数显示日期时间
        System.out.println(date.toString());

        printSimpleFormat();

        printfDate();
    }

    private static void printSimpleFormat() {
        Date dNow = new Date();
        /*
        这一行代码确立了转换的格式，其中 yyyy 是完整的公元年，MM 是月份，dd 是日期，HH:mm:ss 是时、分、秒。
        注意:有的格式大写，有的格式小写，例如 MM 是月份，mm 是分；HH 是 24 小时制，而 hh 是 12 小时制。
        */
        SimpleDateFormat ft = new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz"); 
        System.out.println("当前时间: " + ft.format(dNow));
    }

    private static void printfDate() {
        // 初始化 Date 对象
        Date date = new Date();
    
        //c的使用  
        System.out.printf("全部日期和时间信息：%tc%n",date);          
        //f的使用  
        System.out.printf("年-月-日格式：%tF%n",date);  
        //d的使用  
        System.out.printf("月/日/年格式：%tD%n",date);  
        //r的使用  
        System.out.printf("HH:MM:SS PM格式（12时制）：%tr%n",date);  
        //t的使用  
        System.out.printf("HH:MM:SS格式（24时制）：%tT%n",date);  
        //R的使用  
        System.out.printf("HH:MM格式（24时制）：%tR",date);  
    }
}
