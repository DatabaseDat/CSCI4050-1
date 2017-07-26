package object;

public class ShoppingCart {
	private int cartID;
	private int userID;
	private long ISBN;
	private double price;
	private int quantity;
	private Book book;
	private String bookName;
	
	public ShoppingCart(){
		this.userID = -1;
		this.ISBN = -1;
		this.price = -1;
		this.quantity = -1;
		this.setBook(null);
		this.setBookName(null);
		this.cartID = -1;
	}
	
	public ShoppingCart(int userID, long ISBN, double price, int quantity, Book book, int cartID){
		this.userID = userID;
		this.ISBN = ISBN;
		this.price = price;
		this.quantity = quantity;
		this.setBook(book);
		this.setBookName(book.getBookName());
		this.cartID = cartID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public long getISBN() {
		return ISBN;
	}

	public void setISBN(long iSBN) {
		ISBN = iSBN;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getCartID() {
		return cartID;
	}

	public void setCartID(int cartID) {
		this.cartID = cartID;
	}
	
	
}
