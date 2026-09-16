package foodsafety;

import java.util.ArrayList;
import java.util.List;

public class AssessmentReport {
    private UserProfile user;
    private String productName;
    private List<String> warnings;
    private List<String> bannedSubstances;
    private List<String> healthRisks;

    public AssessmentReport(UserProfile user, String productName) {
        this.user = user;
        this.productName = productName;
        this.warnings = new ArrayList<>();
        this.bannedSubstances = new ArrayList<>();
        this.healthRisks = new ArrayList<>();
    }

    public void addWarning(String warning) { warnings.add(warning); }
    public void addBannedSubstance(String substance) { bannedSubstances.add(substance); }
    public void addHealthRisk(String risk) { healthRisks.add(risk); }

    public void printReport() {
        System.out.println("\n==================================================");
        System.out.println("          FOOD SAFETY & HEALTH RISK REPORT        ");
        System.out.println("==================================================");
        System.out.println("User Profile  : " + user.getName() + " (Age: " + user.getAge() + ", Gender: " + user.getGender() + ")");
        System.out.printf("Calculated BMI: %.2f (%s)\n", user.calculateBMI(), user.getBMICategory());
        System.out.println("Target Product: " + productName);
        System.out.println("--------------------------------------------------");

        if (!bannedSubstances.isEmpty()) {
            System.out.println(" [!] BANNED / CRITICAL SUBSTANCES DETECTED:");
            for (String banned : bannedSubstances) {
                System.out.println("     - " + banned);
            }
        } else {
            System.out.println(" [✓] No strictly banned substances detected.");
        }

        System.out.println("\n [i] SPECIFIC HEALTH WARNINGS FOR YOU:");
        if (warnings.isEmpty()) {
            System.out.println("     - No personalized metabolic warnings triggered.");
        } else {
            for (String w : warnings) {
                System.out.println("     - " + w);
            }
        }

        System.out.println("\n [+] POTENTIAL HEALTH EFFECTS:");
        if (healthRisks.isEmpty()) {
            System.out.println("     - Ingredients appear safe based on database criteria.");
        } else {
            for (String risk : healthRisks) {
                System.out.println("     - " + risk);
            }
        }
        System.out.println("==================================================\n");
    }
}