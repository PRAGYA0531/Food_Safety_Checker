package foodsafety;

public class Ingredient {
    private String name;
    private boolean isAdditive;

    public Ingredient(String name, boolean isAdditive) {
        this.name = name;
        this.isAdditive = isAdditive;
    }

    public String getName() { return name; }
    public boolean isAdditive() { return isAdditive; }
}