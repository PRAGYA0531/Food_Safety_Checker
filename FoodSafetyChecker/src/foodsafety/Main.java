package foodsafety;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DatabaseManager db = new DatabaseManager();

        System.out.println("================================================");
        System.out.println("  HARMFUL SUBSTANCE IN FOOD DETECTOR (CLI)  ");
        System.out.println("================================================");

        try {
            // Module 1: User Profile Capture
            System.out.print("Enter your Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter your Age: ");
            int age = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter your Gender (Male/Female/Other): ");
            String gender = scanner.nextLine();

            System.out.print("Enter Weight (in kg): ");
            double weight = Double.parseDouble(scanner.nextLine());

            System.out.print("Enter Height (in meters, e.g., 1.75): ");
            double height = Double.parseDouble(scanner.nextLine());

            UserProfile user = new UserProfile(name, age, gender, weight, height);

            // Module 2 & 3: Selection & Risk Assessment
            boolean running = true;
            while (running) {
                System.out.println("\nSelect an Option:");
                System.out.println("1. Scan Pre-defined Catalog Product");
                System.out.println("2. Custom Ingredient Check");
                System.out.println("3. Exit");
                System.out.print("Choice: ");

                String choice = scanner.nextLine();
                switch (choice) {
                    case "1":
                        System.out.println("\nAvailable Products in Catalog:");
                        for (String prodName : db.getProductCatalog().keySet()) {
                            System.out.println(" - " + db.getProductCatalog().get(prodName).getName());
                        }
                        System.out.print("Type Product Name to Scan: ");
                        String pName = scanner.nextLine();
                        Product foundProduct = db.findProduct(pName);

                        if (foundProduct != null) {
                            AssessmentReport report = RiskEvaluator.evaluate(user, foundProduct);
                            report.printReport();
                        } else {
                            System.out.println("[Error] Product not found in database.");
                        }
                        break;

                    case "2":
                        System.out.print("Enter additive/ingredient name (e.g., Red 40, High Fructose Corn Syrup): ");
                        String ingName = scanner.nextLine();
                        Additive additive = db.findAdditive(ingName);

                        if (additive != null) {
                            Product tempProduct = new Product("Custom Input: " + ingName, "Custom");
                            tempProduct.addIngredient(additive);
                            AssessmentReport report = RiskEvaluator.evaluate(user, tempProduct);
                            report.printReport();
                        } else {
                            System.out.println("[Notice] Ingredient not flagged as a known toxic additive in local database.");
                        }
                        break;

                    case "3":
                        running = false;
                        System.out.println("Exiting System. Stay healthy AND Eat healthy!");
                        break;

                    default:
                        System.out.println("[Error] Invalid choice. Please select 1, 2, or 3.");
                }
            }

        } catch (NumberFormatException e) {
            System.out.println("[Input Error] Invalid numerical value entered. Restarting required.");
        } catch (Exception e) {
            System.out.println("[System Error] An unexpected error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}