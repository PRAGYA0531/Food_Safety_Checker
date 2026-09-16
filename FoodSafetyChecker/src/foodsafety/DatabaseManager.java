package foodsafety;

import java.util.HashMap;
import java.util.Map;

public class DatabaseManager {
    private Map<String, Additive> additiveRegistry;
    private Map<String, Product> productCatalog;

    public DatabaseManager() {
        additiveRegistry = new HashMap<>();
        productCatalog = new HashMap<>();
        seedDatabase();
    }

    private void seedDatabase() {
        // Register known harmful additives
        Additive red40 = new Additive("Red 40", "HIGH", "Hyperactivity in children, potential allergic reactions", true, false);
        Additive msg = new Additive("Monosodium Glutamate (MSG)", "MEDIUM", "Headaches, numbness, flushing in sensitive individuals", false, false);
        Additive hfcs = new Additive("High Fructose Corn Syrup", "HIGH", "Increased risk of fatty liver disease, type 2 diabetes, obesity", false, true);
        Additive bromate = new Additive("Potassium Bromate", "BANNED", "Carcinogenic properties, banned in multiple regions", true, true);
        Additive transFat = new Additive("Partially Hydrogenated Oil", "HIGH", "Elevates bad cholesterol (LDL), increases heart disease risk", false, true);

        additiveRegistry.put(red40.getName().toLowerCase(), red40);
        additiveRegistry.put(msg.getName().toLowerCase(), msg);
        additiveRegistry.put(hfcs.getName().toLowerCase(), hfcs);
        additiveRegistry.put(bromate.getName().toLowerCase(), bromate);
        additiveRegistry.put(transFat.getName().toLowerCase(), transFat);

        // Pre-populate sample packaged products
        Product soda = new Product("Energy Fizz Drink", "Beverage");
        soda.addIngredient(new Ingredient("Carbonated Water", false));
        soda.addIngredient(hfcs);
        soda.addIngredient(red40);

        Product chips = new Product("Nacho Flavor Chips", "Snacks");
        chips.addIngredient(new Ingredient("Corn Flour", false));
        chips.addIngredient(new Ingredient("Palm Oil", false));
        chips.addIngredient(msg);

        Product bakeryBread = new Product("Enriched White Bread", "Bakery");
        bakeryBread.addIngredient(new Ingredient("Wheat Flour", false));
        bakeryBread.addIngredient(bromate);
        bakeryBread.addIngredient(transFat);

        productCatalog.put(soda.getName().toLowerCase(), soda);
        productCatalog.put(chips.getName().toLowerCase(), chips);
        productCatalog.put(bakeryBread.getName().toLowerCase(), bakeryBread);
    }

    public Additive findAdditive(String name) {
        return additiveRegistry.get(name.toLowerCase());
    }

    public Product findProduct(String name) {
        return productCatalog.get(name.toLowerCase());
    }

    public Map<String, Product> getProductCatalog() {
        return productCatalog;
    }
}