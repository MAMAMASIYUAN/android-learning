public class CustomException {
   public static void main(String [] args) {
      CheckingAccount c = new CheckingAccount(102);
      System.out.println("����500");
      c.deposit(500.00);
      try
      {
         System.out.println("\nȡ100...");
         c.withdraw(100.00);

         System.out.println("\nȡ600...");
         c.withdraw(600.00);
      } catch(InsufficientFundsException e)
      {
         System.out.println("��Ǹ�����㣺"
                                  + e.getAmount());
         e.printStackTrace();
      }
    }
}

class CheckingAccount
{
  //balanceΪ��numberΪ����
   private double balance;
   private int number;
   public CheckingAccount(int number)
   {
      this.number = number;
   }
  //��������Ǯ
   public void deposit(double amount)
   {
 
      balance += amount;
   }
  //������ȡǮ
   public void withdraw(double amount)  throws
    InsufficientFundsException {
      if(amount <= balance)
      {
         balance -= amount;
      }
      else
      {
         double needs = amount - balance;
         throw new InsufficientFundsException(needs);
      }
   }
  //�������������
   public double getBalance()
   {
      return balance;
   }
  //���������ؿ���
   public int getNumber()
   {
      return number;
   }
}

class InsufficientFundsException extends Exception
{
  //�˴���amount�������浱�����쳣��ȡ��Ǯ�������ʱ����ȱ����Ǯ
  private double amount;

  public InsufficientFundsException(double amount) {
    this.amount = amount;
  } 

  public double getAmount() {
    return amount;
  }
}