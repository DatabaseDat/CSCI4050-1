package persistance;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.mysql.jdbc.Connection;

import object.*;

public class DbPersistImpl {

//----------------------------------------------------------------------------------------------------------------------------------------------------------
		//retrieves and returns user login credentials based on type of user
		public int registerUser(String firstName, String lastName, String username, String email, String password, String hashPassword){
			String sql = "INSERT INTO users1 (FirstName, LastName, Email, Password, HashedPassword, Username) VALUES"
				+ "('"+firstName+"','"+lastName+"', '"+email+"', '"+password+"', '"+hashPassword+"', '"+username+"');";
			return DbAccessImpl.create(sql);
		}
//----------------------------------------------------------------------------------------------------------------------------------------------------------		
		//check to see if username already exists
		public int checkUsername(String username) {
			int success = 0;
			String sql = "SELECT * FROM users1 WHERE username = '" + username + "';";
			
			ResultSet r;
			r = DbAccessImpl.retrieve(sql);

			try {
				if (r.next()){
					success++;
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
			String sql = "SELECT * FROM users1 WHERE username = '"+username+"' AND HashedPassword = '"+hash+"'";
	  		ResultSet rs = DbAccessImpl.retrieve(sql);
	  		
	  		try{
	  			if(rs.next()){
	  				if( username.equals(rs.getString("username")) && hash.equals(rs.getString("HashedPassword")) ){
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
			String sql = "SELECT firstName FROM users1 WHERE username = '" + username + "';";
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
		
//----------------------------------------------------------------------------------------------------------------------------------------------------------		
		//return the user type for login purposes
		public int getUserType(String username) {
			int type = -1;
			String sql = "SELECT userType FROM users1 WHERE username = '" + username + "';";
			ResultSet rs = DbAccessImpl.retrieve(sql);
			
			try{
				if(rs.next()){
					type = Integer.parseInt(rs.getString("userType"));
				}
			}catch (SQLException e){
				e.printStackTrace();
			}
			return type;
		}
		
//----------------------------------------------------------------------------------------------------------------------------------------------------------		
		//get user's ID number
		public int getUserID(String username) {
			int id = -1;
			String sql = "SELECT UserID FROM users1 WHERE username = '" + username + "';";
			ResultSet rs = DbAccessImpl.retrieve(sql);
			
			try{
				if(rs.next()){
					id = Integer.parseInt(rs.getString("userID"));
				}
			}catch (SQLException e){
				e.printStackTrace();
			}
			return id;
		}
	
//----------------------------------------------------------------------------------------------------------------------------------------------------------		
		//gets all books - no filters
		public ArrayList<Book> getAllBooks() {
			String sql = "SELECT * FROM books;";
			ArrayList<Book> tempList = new ArrayList<Book>();
			ResultSet rs = DbAccessImpl.retrieve(sql);
			try {
				while(rs.next()) {
					Book b= new Book(rs.getString("Title"), rs.getString("author"), rs.getInt("ISBN"), rs.getDouble("Price"), rs.getString("Category"), rs.getString("Description"));
					tempList.add(b);	
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return tempList;
		}
		
//----------------------------------------------------------------------------------------------------------------------------------------------------------		

		public Book getAllBookInfo(long iSBN) {
			Book b = new Book();
			String sql = "SELECT * FROM books WHERE books.ISBN= '" + iSBN + "';";
			ResultSet rs = DbAccessImpl.retrieve(sql);

			try {
				while(rs.next()) {
					b.setAuthor(rs.getString("author"));
					b.setBookName(rs.getString("Title"));
					b.setCategory(rs.getString("Category"));
					b.setDescription(rs.getString("Description"));
					b.setISBN(rs.getInt("ISBN"));
					b.setPrice(rs.getDouble("Price"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return b;
		}
		
//----------------------------------------------------------------------------------------------------------------------------------------------------------		

		public int addBookToCart(Book b, int userID) {
			int quantity = 1;
			String sql = "INSERT INTO shoppingcart (UserID, ISBN, ActualPrice, Quantity) VALUES"
					+ "('"+userID+"','"+b.getISBN()+"', '"+b.getPrice()+"', '"+quantity+"');";			
			return DbAccessImpl.create(sql);
		}
		
//----------------------------------------------------------------------------------------------------------------------------------------------------------		

		public ArrayList<ShoppingCart> getBooksFromCart(int userID) {
			String sql = "SELECT * FROM shoppingcart WHERE UserID = '" + userID + "';";
			ArrayList<ShoppingCart> tempList = new ArrayList<ShoppingCart>();
			ResultSet rs = DbAccessImpl.retrieve(sql);
			try {
				while(rs.next()) {
					Book b = getAllBookInfo(rs.getLong("ISBN"));
					ShoppingCart s = new ShoppingCart(rs.getInt("UserID"), rs.getLong("ISBN"), rs.getDouble("ActualPrice"), rs.getInt("Quantity"), b, rs.getInt("CartID"));
					tempList.add(s);	
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return tempList;
		}
		
//----------------------------------------------------------------------------------------------------------------------------------------------------------		
		
		public int deleteBook(int cartID) {
			String sql = "DELETE FROM shoppingcart WHERE cartID = '" + cartID + "';";
			return DbAccessImpl.delete(sql);
		}
		
//----------------------------------------------------------------------------------------------------------------------------------------------------------		

		public int updateCart(int cartID, int quantity) {
			String sql = "UPDATE shoppingcart SET Quantity = '" + quantity + "' WHERE CartID = '" + cartID + "';";
			return DbAccessImpl.update(sql);
		}
}