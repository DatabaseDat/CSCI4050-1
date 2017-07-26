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

	//get the first name for UI display
	public String getFirstName(String username) {
		return persist.getFirstName(username);
	}

	//get the user type for proper UI elements based on permissions
	public int getUserType(String username) {
		return persist.getUserType(username);
	}

	//get the user's db ID number
	public int getUserID(String username) {
		return persist.getUserID(username);
	}

	//get all the books for display
	public ArrayList<Book> getAllBooks() {
		return persist.getAllBooks();
	}

	//get all info for a single book
	public Book getAllBookInfo(long iSBN) {
		return persist.getAllBookInfo(iSBN);
	}

	//add book to shopping cart
	public int addBookToCart(Book b, int userID) {
		return persist.addBookToCart(b, userID);
	}

	//get all the books in the cart for a person
	public ArrayList<ShoppingCart> getBooksFromCart(int userID) {
		return persist.getBooksFromCart(userID);
	}

	//delete book from database
	public int deleteBook(String ISBN) {
		return persist.deleteBook(ISBN);
	}
	
}//end class