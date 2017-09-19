import java.io.IOException;  
public class ExceptionSort {  
    public void doSomething() throws IOException{  
        System.out.println("do somthing");  
    }  
    public static void main(String[] args){  
        ExceptionSort es = new ExceptionSort();  
        try {  
            es.doSomething();  
        } catch (Exception e) {  
              
        } catch (IOException e) {  
              
        } 
    }  
  
}  