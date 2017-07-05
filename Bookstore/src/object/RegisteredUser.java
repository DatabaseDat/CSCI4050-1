package object;

public class RegisteredUser extends User{
	private String firstName;
	private String lastName;
	private int DOB;
	private String userName;
	private String password;
	
	public RegisteredUser (){
		this.firstName = null;
		this.lastName = null;
		this.DOB = -1;
		this.userName = null;
		this.password = null;
	}
	
	public RegisteredUser(String fName, String lName, int dob, String uName, String pswd){
		this.setFirstName(fName);
		this.setLastName(lName);
		this.setDOB(dob);
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
	
	public void setDOB(int dob){
		this.DOB = dob;
	}
	
	public int getDOB(){
		return this.DOB;
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
	
	public void subscribePromotions(){
	}
	
	public void unsubscribePromotions(){
	}
	
	public void modifyProfile(String fName, String lName, int dob, String uName, String pswd){
		if (fName != null){
			this.firstName = fName;
		}
		
		if (lName != null){
			this.lastName = lName;
		}
		
		if (dob != -1){
			this.DOB = dob;
		}
		
		if (uName != null){
			this.userName = uName;
		}
		
		if (pswd != null){
			this.password = pswd;
		}
	}
}
