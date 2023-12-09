class BookShop {
    private String name;
    private TextBook[] textBooks;
    private StoryBook[] storyBooks;
    private static final int MAX_BOOKS = 100;
    private int textBookCount;
    private int storyBookCount;

    public BookShop() {
        this.textBooks = new TextBook[MAX_BOOKS];
        this.storyBooks = new StoryBook[MAX_BOOKS];
    }

    public BookShop(String name) {
        this();
        this.name = name;
    }

    public boolean insertTextBook(TextBook tb) {
        if (textBookCount < MAX_BOOKS) {
            textBooks[textBookCount++] = tb;
            return true;
        } else {
            System.out.println("TextBook storage is full.");
            return false;
        }
    }

    public boolean removeTextBook(TextBook tb) {
        for (int i = 0; i < textBookCount; i++) {
            if (textBooks[i].equals(tb)) {
                textBooks[i] = textBooks[--textBookCount];
                textBooks[textBookCount] = null;
                return true;
            }
        }
        return false;
    }

    public TextBook searchTextBook(String isbn) {
        for (int i = 0; i < textBookCount; i++) {
            if (textBooks[i].getIsbn().equals(isbn)) {
                return textBooks[i];
            }
        }
        return null;
    }

    public void showAllTextBooks() {
        for (int i = 0; i < textBookCount; i++) {
            textBooks[i].showDetails();
            System.out.println();
        }
    }

    public boolean insertStoryBook(StoryBook sb) {
        if (storyBookCount < MAX_BOOKS) {
            storyBooks[storyBookCount++] = sb;
            return true;
        } else {
            System.out.println("StoryBook storage is full.");
            return false;
        }
    }

    public boolean removeStoryBook(StoryBook sb) {
        for (int i = 0; i < storyBookCount; i++) {
            if (storyBooks[i].equals(sb)) {
                storyBooks[i] = storyBooks[--storyBookCount];
                storyBooks[storyBookCount] = null;
                return true;
            }
        }
        return false;
    }

    public StoryBook searchStoryBook(String isbn) {
        for (int i = 0; i < storyBookCount; i++) {
            if (storyBooks[i].getIsbn().equals(isbn)) {
                return storyBooks[i];
            }
        }
        return null;
    }

    public void showAllStoryBooks() {
        for (int i = 0; i < storyBookCount; i++) {
            storyBooks[i].showDetails();
            System.out.println();
        }
    }
}
