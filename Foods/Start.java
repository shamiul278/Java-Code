public class Start {
    public static void main(String[] args) {
        // Create two objects of Drinks, Burger, and Pizza
        Drinks drink1 = new Drinks("Soda", new String[]{"Water", "Sugar", "Flavor"}, 1.99, 150, "Soft Drink", 5);
        Drinks drink2 = new Drinks("Fruit Juice", new String[]{"Fruit", "Water", "Sugar"}, 2.49, 120, "Fruit Juice", 25);

        Burger burger = new Burger("Cheeseburger", new String[]{"Bun", "Cheese", "Patty", "Lettuce", "Tomato", "Onion"}, 4.99, 500, 1);

        Pizza pizza = new Pizza("Pepperoni Pizza", new String[]{"Dough", "Tomato Sauce", "Cheese", "Pepperoni"}, 9.99, 800, 12);

        // Demonstrate the methods and constructors
        System.out.println("Drink 1: " + drink1.getName() + ", " + drink1.getType() + ", " + drink1.getSize() + "L");
        System.out.println("Drink 2: " + drink2.getName() + ", " + drink2.getType() + ", " + drink2.getSize() + "L");

        burger.showDetails();
        pizza.showDetails();
    }
}
