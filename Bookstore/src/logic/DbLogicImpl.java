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
	public int registerUser(String firstName, String lastName, String username, String password, String hashPassword){
		return persist.registerUser(firstName, lastName, username, password, hashPassword);
	}

	//checks if username already exists - used for registration
	public int checkUser(String username){
		return persist.checkUsername(username);	
	}

	//checks user criteria for login
		public int checkUserLogin(String username, String hash){
			return persist.checkUserLogin(username, hash);
		}
	
}//end class