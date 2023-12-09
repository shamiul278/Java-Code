 public class Start {
	 
	public static void main(String[] args) {
     
		StoryBook sb1 = new StoryBook("001", "Harry Potter", "J.K. Rowling", 300, 50, "Children");
		StoryBook sb2 = new StoryBook("002", "A Game of Thrones", "George R.R. Martin", 500, 30, "Fantasy");

			sb1.showDetails();
			sb2.showDetails();
			StoryBook.setDiscountRate(10);

			sb1.setPrice(sb1.getPrice() - sb1.getPrice() * StoryBook.getDiscountRate() / 100);
			sb2.setPrice(sb2.getPrice() - sb2.getPrice() * StoryBook.getDiscountRate() / 100);

			sb1.showDetails();
			System.out.println();
			sb2.showDetails();

			System.out.println();
			
		Textbook book1 = new Textbook("101", "Physics", "Newton", 300, 20, 12);
		Textbook book2 = new Textbook("102", "Chemistry", "Dalton", 250, 15, 11);

			book1.showDetails();
			book2.showDetails();
			Textbook.setDiscountRate(10);
			
			book1.setPrice(book1.getPrice() - book1.getPrice() * Textbook.getDiscountRate() / 100);
			book2.setPrice(book2.getPrice() - book2.getPrice() * Textbook.getDiscountRate() / 100);

			book1.showDetails();
			System.out.println();
			book2.showDetails();
    }
 }