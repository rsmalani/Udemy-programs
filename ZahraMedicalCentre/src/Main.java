import java.util.Scanner;

public class Main {
    static double bmi = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Zahra Medical Centre");
        System.out.println("Enter login credentials:");
        System.out.println("UserId:");
        String userId = sc.next();
        System.out.println("Password");
        String password = sc.next();

        while (!userId.equals("zahraStaff") && password.equals("zahraStaff@centre")) {
            System.out.println("Enter correct credentials");
            System.out.println("UserId:");
            userId = sc.next();
            System.out.println("Password");
            password = sc.next();
        }

        System.out.println("Enter child patients height in (metres) : ");
        double height = sc.nextDouble();
        System.out.println("Enter patients weight in (kg) : ");
        double weight = sc.nextDouble();

        String bmiStatus = _BMICalculator(weight, height);
        System.out.println("BMI of the patient is " + bmi);
        System.out.println("BMI Status of the patient is " + bmiStatus);

        System.out.println("Enter the cardiac output of the patient :");
        double cardiacOutput = sc.nextDouble();
        double bsa = _BSACalculator(weight, height);
        System.out.println("Cardiac index of the patient is " + cardiacIndex(cardiacOutput, bsa));

        System.out.println("Enter dose's name : ");
        String dose = sc.next();
        System.out.println("Enter dose value in (mg) : ");
        double doseQuantity = sc.nextDouble();

        System.out.println("The " + dose + " dose required for the child is" + childDoseCalculator(bsa, doseQuantity));
        System.out.println("Thank you for using Zahra Medical Centre's terminal");
    }
    private static String _BMICalculator(double weight, double height) {
        bmi = weight/(height * height);
        if (bmi < 18.5)
            return "Underweight";
        if (bmi < 25)
            return "Normal Weight";
        if (bmi < 30)
            return "Overweight";
        return "Obese";
    }

    private static float _BSACalculator(double weight, double height) {
        return (float) Math.sqrt(height * weight / 36);
    }

    private static double cardiacIndex(double cardiacOutput, double bsa) {
        return cardiacOutput / bsa;
    }

    private static double childDoseCalculator(double bsa, double dose) {
        return (bsa / 1.72 * dose);
    }
}