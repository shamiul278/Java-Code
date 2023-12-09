class Pizza extends Food {
    private int sizeInInches;

    public Pizza() {}

    public Pizza(String name, String[] ingredients, double price, float calories, int sizeInInches) {
        super(name, ingredients, price, calories);
        this.sizeInInches = sizeInInches;
    }

    public void setSize(int sizeInInches) {
        this.sizeInInches = sizeInInches;
    }

    public int getSize() {
        return sizeInInches;
    }

    public void showDetails() {
        System.out.println("Pizza: " + getName() + ", " + getSize() + " inches");
    }
}
