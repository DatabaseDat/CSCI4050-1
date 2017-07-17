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
		//retrieves and returns user login credentials based on type of user
		public int registerUser(String firstName, String lastName, String username, String email, String password, String hashPassword){
			String sql = "INSERT INTO users (LastName, FirstName, Email, Password, HashedPassword, Username) VALUES"
				+ "('"+lastName+"','"+firstName+"', '"+email+"', '"+password+"', '"+hashPassword+"', '"+username+"');";
			
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

//----------------------------------------------------------------------------------------------------------------------------------------------------------		
		//get user's first name
		public String getFirstName(String username) {
			String name = null;
			String sql = "SELECT firstName FROM Users WHERE username = '" + username + "';";
			ResultSet rs = DbAccessImpl.retrieve(sql);
			
			try{
				if(rs.next()){
					name = rs.getString("firstName");
				}
			}catch (SQLException e){
				e.printStackTrace();
			}
			return name;
		}
}