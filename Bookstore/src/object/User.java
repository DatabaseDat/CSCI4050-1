package object;

public class User {
	private int userID;
	private String email;
	private String billingAddress;
	private int userType;
	

	public void setUserID(int uID){
		this.userID = uID;
	}
	
	public int getUserID (){
		return this.userID;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public String getEmail(){
		return this.email;
	}
	
	public void setBillingAddress(String bAddress){
		this.billingAddress = bAddress;
	}
	
	public String getBillingAddress(){
		return this.billingAddress;
	}
	
	public void browse(String title, String author, String category, long ISBN){
		
	}
	
	public void Register (String fName, String lName, int DOB, String uName, String pswd){
		RegisteredUser u = new RegisteredUser(fName, lName, DOB, uName, pswd);		
	}
}
