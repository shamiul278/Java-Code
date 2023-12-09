import java.lang.*;

public class BookShop{
	private String bookShopName;
	private Book books[] = new Book[100];
	
	public BookShop(){
		System.out.println("BookShop empty constructor called");
	}
	public BookShop(String bookShopName){
		this.bookShopName = bookShopName;
	}
	public void setName(String bookShopName){
		this.bookShopName = bookShopName;
	}
	public String getName(){
		return this.bookShopName;
	}
	public void insertBook(Book b){
		for(int i = 0; i<books.length ; i++){
			if(books[i]==null){
				books[i] = b;
				break;
			}
		}
	}
	public void removeBook(Book b){
		for(int i = 0; i<books.length ; i++){
			if(books[i]==b){
				books[i] = null;
				break;
			}
		}
		System.out.println(b.getBookTitle() + " - book is removed.");
		System.out.println("");
	}
	public Book searchBook(String isbn){
		Book b = new Book();
		for(int i = 0; i<books.length ; i++){
			if((books[i].getISBN()).equals(isbn)){
				b = books[i];
				break;
			}
		}
		return b;
	}
	public void showAllBooks(){
		System.out.println("***BookShop: " + bookShopName);
		System.out.println("");
		for(int i = 0; i<books.length ; i++){
			if(books[i]!=null){
				books[i].showDetails();
				System.out.println("");
			}
		}
	}
}