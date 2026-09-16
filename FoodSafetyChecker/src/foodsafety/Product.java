package foodsafety;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private String name;
    private String category;
    private List<Ingredient> ingredients;

    public Product(String name, String category) {
        this.name = name;
        this.category = category;
        this.ingredients = new ArrayList<>();
    }

    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    public String getName() { return name; }
    public String getCategory() { return category; }
    public List<Ingredient> getIngredients() { return ingredients; }
}