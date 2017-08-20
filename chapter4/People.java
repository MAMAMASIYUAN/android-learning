//类
public class People {
    final String hi = "Hello, ";
    //构造函数
    public People() {

    }
    //主函数，程序入口
   public static void main(String[] args) {
       //对象
        People appleFather = new People();
        //变量
        String name = appleFather.getName();
      // 在终端或者命令行窗口输出一行文字
      System.out.println(appleFather.hi + name);
   }

    //方法，或者叫函数
   public String getName() {
       String firstName = "Steve";
       String laststName = "Jobs";
       return firstName + " " + laststName;
   }
}