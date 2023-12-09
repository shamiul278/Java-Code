 public class Start{
	   public static void main(String[] args) {
        Book myBook = new Book();

        myBook.setIsbn("1234567890");
        myBook.setBookTitle("Sample Book");
        myBook.setAuthorName("John Doe");
        myBook.setPrice(19.99);
        myBook.setAvailableQuantity(10);

        myBook.addQuantity(10);
        myBook.sellQuantity(5);

        myBook.showDetails();
    }
}
