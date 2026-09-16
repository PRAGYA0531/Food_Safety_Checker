package foodsafety;

public class Additive extends Ingredient {
    private String riskLevel; // LOW, MEDIUM, HIGH, BANNED
    private String healthEffects;
    private boolean restrictedForChildren;
    private boolean restrictedForHighBMI;

    public Additive(String name, String riskLevel, String healthEffects, boolean restrictedForChildren, boolean restrictedForHighBMI) {
        super(name, true);
        this.riskLevel = riskLevel;
        this.healthEffects = healthEffects;
        this.restrictedForChildren = restrictedForChildren;
        this.restrictedForHighBMI = restrictedForHighBMI;
    }

    public String getRiskLevel() { return riskLevel; }
    public String getHealthEffects() { return healthEffects; }
    public boolean isRestrictedForChildren() { return restrictedForChildren; }
    public boolean isRestrictedForHighBMI() { return restrictedForHighBMI; }
}