package object;

public class Guest extends User{
	
	public void browse(String title, String author, String category, long ISBN){
		
	}
	
	public void Register (String fName, String lName, int DOB, String uName, String pswd){
		RegisteredUser u = new RegisteredUser(fName, lName, DOB, uName, pswd);		
	}
}
