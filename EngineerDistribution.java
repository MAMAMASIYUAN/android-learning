public class EngineerDistribution{
 public static void main(String [] args) {
   if(args!=null&&args.length>0){
        int num=Integer.parseInt(args[0]);  
        Project a = new Project(num);

    try
    {
         System.out.println("\n项目需要120人，开始分配...");
         System.out.println("\n分配中... ... ...\n");
         a.Distribution(120);

    }catch(InsufficientFundsException d)
     {
        System.out.println("分配结果：共有"+num+"人，人员不足，还需"
                                  + d.getNeed()+"人。\n");
      d.printStackTrace();

      }
   }

 }


}

class Project{
  private int TotalEngineerNumber; 
  private int RemanentEngineerNumber;
  public Project(int Number)
   {
      this.TotalEngineerNumber = Number;
   }
  //分配人员
   public void Distribution(int Number)  throws
                              InsufficientFundsException {
      if(TotalEngineerNumber>= Number)
      {
         RemanentEngineerNumber= TotalEngineerNumber-120;
         System.out.println("分配结果：共有"+TotalEngineerNumber+"人，人员足够，还剩余"+RemanentEngineerNumber+"人未分配。\n");
      }
      else
      {
         int needs = Number - TotalEngineerNumber;
         throw new InsufficientFundsException(needs);
      }
   }
   
}


class InsufficientFundsException extends Exception
{
int NeedEngineerNumber;

  public InsufficientFundsException(int NeedEngineerNumber) {
    this.NeedEngineerNumber = NeedEngineerNumber;
  } 

//返回所需工程师人数
   public int getNeed()
   {
      return NeedEngineerNumber;
   }

}
