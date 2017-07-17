package object;

public class User {
	private int userID;
	private String password;
	private String userType;
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	public String verifyUser(int userID, String password){
		return null;
	}
	
	public Book viewBooks(){
		return null;
	}
	
	public Book viewBooksByCategory(String option){
		return null;
	}	
}