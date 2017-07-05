package persistance;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.mysql.jdbc.Connection;

import object.*;

public class DbPersistImpl {
	
//----------------------------------------------------------------------------------------------------------------------------------------------------------
	
	//retreives and returns user login credentials based on type of user
	public RegisteredUser getUserLogin(String username){
		String sql = "SELECT * FROM Users WHERE Username = '" + username + "';";
		ResultSet r = DbAccessImpl.retrieve(sql);
		RegisteredUser ru = new RegisteredUser();

		try {
			if (r.next()){
					ru.setFirstName(r.getString("FirstName"));
					System.out.println(ru.getFirstName());
					ru.setLastName(r.getString("LastName"));
					System.out.println(ru.getLastName());
					ru.setPassword(r.getString("HashedPassword"));
					System.out.println(ru.getPassword());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return ru;
	}
//----------------------------------------------------------------------------------------------------------------------------------------------------------
		//retrieves and returns user login credentials based on type of user
		public int registerUser(String firstName, String lastName, String username, String password, String hashPassword){
			String sql = "INSERT INTO users (LastName, FirstName, Password, HashedPassword, Username) VALUES"
				+ "('"+lastName+"','"+firstName+"', '"+password+"', '"+hashPassword+"', '"+username+"');";
			
			return DbAccessImpl.create(sql);
		}
//----------------------------------------------------------------------------------------------------------------------------------------------------------		
		//check to see if username already exists
		public int checkUsername(String username) {
			int success = 0;
			String sql = "SELECT * FROM Users WHERE username = '" + username + "';";
			
			ResultSet r;
			r = DbAccessImpl.retrieve(sql);

			try {
				if (r.next()){
					success++;
					System.out.println("success: " + success);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return success;
		}
		
//----------------------------------------------------------------------------------------------------------------------------------------------------------		
		//checks user login criteria
		public int checkUserLogin(String username, String hash){
			int success = 0;
			String sql = "SELECT * FROM users WHERE Username = '"+username+"' AND HashedPassword = '"+hash+"'";
	  		ResultSet rs = DbAccessImpl.retrieve(sql);
	  		
	  		try{
	  			if(rs.next()){
	  				if( username.equals(rs.getString("Username")) && hash.equals(rs.getString("HashedPassword")) ){
	  					success = 1;
	  				}
	  			}else{
	  				success = 0;
	  			}
	  		}catch(SQLException e){
	  			e.printStackTrace();
	  		}
	  		
	  		return success;
		}
}