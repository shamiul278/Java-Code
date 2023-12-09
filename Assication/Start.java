public class Start {
    public static void main(String[] args) {

        TextBook tb1 = new TextBook("T1", "Textbook 1", "Author 1", 20.0, 50, 10);
        TextBook tb2 = new TextBook("T2", "Textbook 2", "Author 2", 25.0, 30, 8);
        TextBook tb3 = new TextBook("T3", "Textbook 3", "Author 3", 18.0, 40, 12);
        TextBook tb4 = new TextBook("T4", "Textbook 4", "Author 4", 22.0, 20, 6);
        TextBook tb5 = new TextBook("T5", "Textbook 5", "Author 5", 15.0, 35, 9);


        StoryBook sb1 = new StoryBook("S1", "Storybook 1", "Author 6", 15.0, 40, "Fiction");
        StoryBook sb2 = new StoryBook("S2", "Storybook 2", "Author 7", 18.0, 20, "Mystery");
        StoryBook sb3 = new StoryBook("S3", "Storybook 3", "Author 8", 22.0, 30, "Adventure");
        StoryBook sb4 = new StoryBook("S4", "Storybook 4", "Author 9", 20.0, 25, "Science Fiction");
        StoryBook sb5 = new StoryBook("S5", "Storybook 5", "Author 10", 25.0, 15, "Fantasy");


        BookShop bookShop = new BookShop("My Bookstore");


        bookShop.insertTextBook(tb1);
        bookShop.insertTextBook(tb2);
        bookShop.insertTextBook(tb3);
        bookShop.insertTextBook(tb4);
        bookShop.insertTextBook(tb5);


        bookShop.insertStoryBook(sb1);
        bookShop.insertStoryBook(sb2);
        bookShop.insertStoryBook(sb3);
        bookShop.insertStoryBook(sb4);
        bookShop.insertStoryBook(sb5);


        System.out.println("All TextBooks in the BookShop:");
        bookShop.showAllTextBooks();


        System.out.println("\nAll StoryBooks in the BookShop:");
        bookShop.showAllStoryBooks();


        TextBook searchedTextBook = bookShop.searchTextBook("T3");
        if (searchedTextBook != null) {
            System.out.println("\nSearched TextBook found:");
            searchedTextBook.showDetails();
        } else {
            System.out.println("\nSearched TextBook not found.");
        }


        StoryBook searchedStoryBook = bookShop.searchStoryBook("S4");
        if (searchedStoryBook != null) {
            System.out.println("\nSearched StoryBook found:");
            searchedStoryBook.showDetails();
        } else {
            System.out.println("\nSearched StoryBook not found.");
        }
    }
}
