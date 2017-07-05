package object;

public class Book {
	private String bookName;
	private String author;
	private long ISBN;
	private double price;
	private String category;
	
	public Book(){
		this.bookName = null;
		this.author = null;
		this.ISBN = -1;
		this.price = -1;
		this.category = null;
	}
	
	public Book (String bName, String a, long isbn, double p, String c){
		this.setAuthor(a);
		this.setBookName(bName);
		this.setISBN(isbn);
		this.setPrice(p);
		this.setCategory(c);
	}
	
	public String getBookName() {
		return this.bookName;
	}
	public void setBookName(String bName) {
		this.bookName = bName;
	}
	public String getAuthor() {
		return this.author;
	}
	public void setAuthor(String a) {
		this.author = a;
	}
	public long getISBN() {
		return this.ISBN;
	}
	public void setISBN(long isbn) {
		this.ISBN = isbn;
	}
	public double getPrice() {
		return this.price;
	}
	public void setPrice(double p) {
		this.price = p;
	}
	public String getCategory() {
		return this.category;
	}
	public void setCategory(String c) {
		this.category = c;
	}
	
	public Book getBook(){
		Book b = new Book();
		b.setBookName(this.bookName);
		b.setAuthor(this.author);
		b.setISBN(this.ISBN);
		b.setPrice(this.price);
		b.setCategory(this.category);
		
		return b;
	}
	
	
}
