package object;

public class Vendor extends User{
	public String firstName;
	public String lastName;
	public String companyName;
	public String userName;
	public String password;

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
	
	public void setCompanyName(String cName){
		this.companyName = cName;
	}
	
	public String getCompanyName(){
		return this.companyName;
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
	
	public void deleteBook (Book b){
	}
	
	public void updateBook(){
	}
}
