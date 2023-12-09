public class Book{
	private String isbn;
	private String bookTitle;
	private String authorName;
	private double price;
	private int availableQuantity;
	
	public Book(){
		System.out.println("Book class: Non-parameterized constructor called.");
	}
	public Book(String isbn, String bookTitle, String authorName, double price, int availableQuantity){
		this.isbn = isbn;
		this.bookTitle = bookTitle;
		this.authorName = authorName;
		this.price = price;
		this.availableQuantity = availableQuantity;
	}
	//Setter methods
	public void setISBN(String isbn){
		this.isbn = isbn;
	}
	public void setBookTitle(String bookTitle){
		this.bookTitle = bookTitle;
	}
	public void setAuthorName(String authorName){
		this.authorName = authorName;
	}
	public void setPrice(double price){
		this.price = price;
	}
	public void setAvailableQuantity(int availableQuantity){
		this.availableQuantity = availableQuantity;
	}
	//Getter methods
	public String getISBN(){
		return this.isbn;
	}
	public String getBookTitle(){
		return this.bookTitle;
	}
	public String getAuthorName(){
		return this.authorName;
	}
	public double getPrice(){
		return this.price;
	}
	public int getAvailableQuantity(){
		return this.availableQuantity;
	}
	
	public void showDetails(){
		System.out.println("ISBN: " + this.isbn);
		System.out.println("Book title: " + this.bookTitle);
		System.out.println("Author name: " + this.authorName);
		System.out.println("Price: " + this.price);
		System.out.println("Current availability: " + this.availableQuantity);
	}
	public void addQuantity(int amount){
		System.out.print("Adding "+amount+" books. ");
		this.availableQuantity = this.availableQuantity + amount;
	}
	public void sellQuantity(int amount){
		if(this.availableQuantity>=amount){
			this.availableQuantity = this.availableQuantity - amount;
			System.out.print(amount + " books sold. ");
		}else{
			System.out.println("Not enough quantities.");
		}
		
	}
}













