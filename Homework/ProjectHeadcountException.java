public class ProjectHeadcountException{
  public static void main(String [] args){
    CheckHeadcount h = new CheckHeadcount();
    System.out.println("\n Recruited 100 men");
    h.recruit(100);

    try{
        System.out.println("\n Project needes 120 men.");
        h.needs(120);
    } catch(OutOfHeadcount e){
        System.out.println("\n Out of headcount: " + e.getHeadcount() + " men.");
         e.printStackTrace();
    }


 }
}

class CheckHeadcount{
    private int headcount;
    
    //Function:recruit new comer
    public void recruit(int number){

        headcount = headcount + number;
    }

    //Function:project needed number
    public void needs(int number) throws OutOfHeadcount{

        if(number <= headcount){
            headcount -= number;
        }
        else{
            int needs = number - headcount;
            throw new OutOfHeadcount(needs);
        }
    }
    //Function: return remain headcount
    public int getHeadcount(){
        return headcount;
    }
}

class OutOfHeadcount extends Exception{
    private int needed;

    public OutOfHeadcount(int needed){
        this.needed = needed;
    }
 
    public int getHeadcount(){
        return needed;
    }

}