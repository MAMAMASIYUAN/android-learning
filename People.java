//Class
public class People{
	final String hi = "Hello,";
	//Constructor 
	public People(){
	}
	//Main function, entry
	public static void main(String[] args){
		//project
		People appleFather = new People();
		//Varible
		String name = appleFather.getName();
		//print a string
		System.out.println(appleFather.hi + name);
	}

	//function
    public String getName(){
		String firstName = "Steve";
		String lastName = "Jobs";
		return firstName + "" + lastName;
	}
	
}