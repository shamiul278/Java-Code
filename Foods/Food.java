class Food {
    private String name;
    private String[] ingredients;
    private double price;
    private float calories;

    public Food() {
    }

    public Food(String name, String[] ingredients, double price, float calories) {
        this.name = name;
        this.ingredients = ingredients;
        this.price = price;
        this.calories = calories;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setIngredients(String[] ingredients) {
        this.ingredients = ingredients;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCalories(float calories) {
        this.calories = calories;
    }


    public String getName() {
        return name;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public double getPrice() {
        return price;
    }

    public float getCalories() {
        return calories;
    }


    public void removeIngredient(String ingredient) {
        for (int i = 0; i < ingredients.length; i++) {
            if (ingredients[i] != null && ingredients[i].equals(ingredient)) {
                ingredients[i] = null;
            }
        }
    }

    public void addIngredient(String ingredient) {
        int count = 0;
        for (String i : ingredients) {
            if (i != null) {
                count++;
            }
        }
        String[] newIngredients = new String[count + 1];
        for (int i = 0, j = 0; i < ingredients.length; i++) {
            if (ingredients[i] != null) {
                newIngredients[j++] = ingredients[i];
            }
        }
        newIngredients[count] = ingredient;
        ingredients = newIngredients;
    }

    public void showDetails() {
        System.out.println("Food Name: " + getName());
        System.out.println("Ingredients: ");
        for (String ingredient : getIngredients()) {
            if (ingredient != null) {
                System.out.println("- " + ingredient);
            }
        }
        System.out.println("Price: " + getPrice());
        System.out.println("Calories: " + getCalories());
    }
}

