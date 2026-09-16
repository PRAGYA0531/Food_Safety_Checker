package foodsafety;

public class RiskEvaluator {

    public static AssessmentReport evaluate(UserProfile user, Product product) {
        AssessmentReport report = new AssessmentReport(user, product.getName());

        for (Ingredient ing : product.getIngredients()) {
            if (ing.isAdditive() && ing instanceof Additive) {
                Additive additive = (Additive) ing;

                if (additive.getRiskLevel().equalsIgnoreCase("BANNED")) {
                    report.addBannedSubstance(additive.getName() + " - " + additive.getHealthEffects());
                } else {
                    report.addHealthRisk(additive.getName() + " (" + additive.getRiskLevel() + " Risk): " + additive.getHealthEffects());
                }

                // Age-based safety check
                if (user.getAge() < 12 && additive.isRestrictedForChildren()) {
                    report.addWarning("AGE ALERT: " + additive.getName() + " is restricted/unhealthy for children under 12.");
                }

                // BMI-based metabolic safety check
                if ((user.getBMICategory().equals("Overweight") || user.getBMICategory().equals("Obese")) && additive.isRestrictedForHighBMI()) {
                    report.addWarning("BMI ALERT: " + additive.getName() + " poses extra metabolic risks for " + user.getBMICategory() + " profile.");
                }
            }
        }
        return report;
    }
}
