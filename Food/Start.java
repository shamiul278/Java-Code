public class Start50{
	public static void main(String[] args) {
        Food f1 = new Food();

        f1.setName("Burger");
        f1.setIngredients(new String[]{"Beef patty", "Bun", "Lettuce", "Tomato", "Cheese"});
        f1.setPrice(5.49);
        f1.setCalories(500.0f);
        f1.showDetails();
		
		System.out.println("");    
		System.out.println("-----------------------------------");
		System.out.println("");
		
        Food f2 = new Food();
        f2.setName("Salad");
        f2.setIngredients(new String[]{"Lettuce", "Tomato", "Cucumber"});
        f2.setPrice(4.49);
        f2.setCalories(150.0f);
        f2.showDetails();
    }
}