public class Start{
	public static void main(String[] args){
		StoryBook s1 = new StoryBook();
		System.out.println("");
		StoryBook s2 = new StoryBook("9781408855652","Harry Potter and the Philosopher's Stone","J.K. Rowling",1134.13, 20, "Fantasy Novel");
		s2.showDetails();
		StoryBook s3 = new StoryBook("978-1503215153","Around the World in Eighty Days","Jules Verne",555.45, 10, "Adventure Novel ");
		s2.showDetails();
		
		System.out.println("");
		TextBook t1 = new TextBook();
		TextBook t2 = new TextBook("978-1260463415","Java Complete Reference","Herbert Schildt",500.5,30,13);
		t2.showDetails();
		TextBook t3 = new TextBook("10:0596009208","Head First Java","Kathy Sierra and Bert Bates",600.5,20,14);
		t3.showDetails();
		
		System.out.println("");
		BookShop bs = new BookShop("AIUB Library");
		
		bs.insertBook(s2);
		bs.insertBook(s3);
		bs.insertBook(t2);
		bs.insertBook(t3);
		bs.insertBook(t3);
		bs.showAllBooks();
		bs.removeBook(t3);
		bs.showAllBooks();
		
		Book b = bs.searchBook("978-1260463415");
		System.out.println("***Searched book: ");
				b.showDetails();
	}
}