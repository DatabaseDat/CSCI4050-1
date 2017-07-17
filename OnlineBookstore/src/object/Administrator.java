package object;

public class Administrator extends User{
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	
	public Administrator(){
		this.firstName = null;
		this.lastName = null;
		this.userName = null;
		this.password = null;
	}
	
	public Administrator (String fName, String lName, String uName, String pswd){
		this.setFirstName(fName);
		this.setLastName(lName);
		this.setUserName(uName);
		this.setPassword(pswd);
	}
	
	public void setFirstName(String fName){
		this.firstName = fName;
	}
	
	public String getFirstName(){
		return this.firstName;
	}
	
	public void setLastName(String lName){
		this.lastName = lName;
	}
	
	public String getLastName(){
		return this.lastName;
	}
	
	public void setUserName(String uName){
		this.userName = uName;
	}
	
	public String getUserName(){
		return this.userName;
	}
	
	public void setPassword(String pswd){
		this.password = pswd;
	}
	
	public String getPassword(){
		return this.password;
	}
	
	public void addBook(Book b){	
	}
	
	public void deleteBook(Book b){
	}
	
	public void addMember(RegisteredUser ru){
	}

	public void removeMember(RegisteredUser ru){
	}
	
	public void viewReviews(){
	}
	
	public void deleteReviews(){
	}
	
	public void addPromotion(Promotion p){
	}
	
	public void deletePromotion(Promotion p){
	}
}
