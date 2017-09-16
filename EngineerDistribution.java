public class EngineerDistribution{
 public static void main(String [] args) {
   if(args!=null&&args.length>0){
        int num=Integer.parseInt(args[0]);  
        Project a = new Project(num);

    try
    {
         System.out.println("\n��Ŀ��Ҫ120�ˣ���ʼ����...");
         System.out.println("\n������... ... ...\n");
         a.Distribution(120);

    }catch(InsufficientFundsException d)
     {
        System.out.println("������������"+num+"�ˣ���Ա���㣬����"
                                  + d.getNeed()+"�ˡ�\n");
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
  //������Ա
   public void Distribution(int Number)  throws
                              InsufficientFundsException {
      if(TotalEngineerNumber>= Number)
      {
         RemanentEngineerNumber= TotalEngineerNumber-120;
         System.out.println("������������"+TotalEngineerNumber+"�ˣ���Ա�㹻����ʣ��"+RemanentEngineerNumber+"��δ���䡣\n");
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

//�������蹤��ʦ����
   public int getNeed()
   {
      return NeedEngineerNumber;
   }

}
