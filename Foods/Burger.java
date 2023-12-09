class Burger extends Food {
    int numberOfPatty;

    public Burger() {}

    public Burger(String name, String[] ingredients, double price, float calories, int numberOfPatty) {
        super(name, ingredients, price, calories);
        this.numberOfPatty = numberOfPatty;
    }

    public void setNumberOfPatty(int numberOfPatty) {
        this.numberOfPatty = numberOfPatty;
    }

    public int getNumberOfPatty() {
        return numberOfPatty;
    }

    public void showDetails() {
        System.out.println("Burger: " + this.getName() + ", " + this.getNumberOfPatty() + " patty");
    }
}
