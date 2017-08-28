import java.util.*;
import java.text.*;
 
  
public class DateFromStringDemo {
   public static void main(String args[]) {
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd"); 
    
        String input = "2017-08-26"; 
    
        System.out.print(input + " 解析为 "); 
    
        Date t; 
    
        try { 
            t = ft.parse(input); 
            System.out.println(t); 
        } catch (ParseException e) { 
            System.out.println("日期转换失败：" + ft); 
        }
    }
}