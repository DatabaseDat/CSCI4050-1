package logic;

import object.*;
import persistance.DbPersistImpl;

import java.util.ArrayList;

public class DbLogicImpl {
	
DbPersistImpl persist;
	
	public DbLogicImpl(){
		persist = new DbPersistImpl();
	}
	
	//insert new registered user
	public int registerUser(String firstName, String lastName, String username, String email, String password, String hashPassword){
		//make sure first name is in standard format
		firstName.toUpperCase();
		String firstLetter = firstName.substring(0,1);
		String theRest = firstName.substring(1);
		theRest.toLowerCase();
		String firstName2 = firstLetter + theRest;
		
		//make sure last name is in standard format
		lastName.toUpperCase();
		String lastFirstLetter = lastName.substring(0,1);
		String lastTheRest = lastName.substring(1);
		lastTheRest.toLowerCase();
		String lastName2 = lastFirstLetter + lastTheRest;
	
		return persist.registerUser(firstName2, lastName2, username, email, password, hashPassword);
	}

	//checks if username already exists - used for registration
	public int checkUser(String username){
		return persist.checkUsername(username);	
	}

	//checks user criteria for login
	public int checkUserLogin(String username, String hash){
		return persist.checkUserLogin(username, hash);
	}

	public String getFirstName(String username) {
		return persist.getFirstName(username);
	}
	
}//end class