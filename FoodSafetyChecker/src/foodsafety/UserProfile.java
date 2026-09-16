package foodsafety;

public class UserProfile {
    private String name;
    private int age;
    private String gender;
    private double weightKg;
    private double heightMeters;

    public UserProfile(String name, int age, String gender, double weightKg, double heightMeters) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.weightKg = weightKg;
        this.heightMeters = heightMeters;
    }

    public double calculateBMI() {
        if (heightMeters <= 0) return 0.0;
        return weightKg / (heightMeters * heightMeters);
    }

    public String getBMICategory() {
        double bmi = calculateBMI();
        if (bmi < 18.5) return "Underweight";
        if (bmi < 25.0) return "Normal weight";
        if (bmi < 30.0) return "Overweight";
        return "Obese";
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public String getGender() { return gender; }
}