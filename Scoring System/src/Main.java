import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        HashMap<Integer, String> stabelford = new HashMap<>();
        stabelford.put(2, "Stabelford Point - Double bogey or Wipe");
        stabelford.put(1, "Stabelford Point - Bogey");
        stabelford.put(0, "Stabelford Point - Par");
        stabelford.put(-1, "Stabelford Point - Birdie");
        stabelford.put(-2, "Stabelford Point - Double birdie");
        stabelford.put(-3, "Stabelford Point - Albatross");
        stabelford.put(-4, "Stabelford Point - Condor");

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to sports scoring system");
        Thread.sleep(200);
        System.out.println("Would you like to begin calculating you score.");
        Thread.sleep(200);
        int choice;
        do {
            System.out.println("Choose the sport you want to select for scoring - ");
            System.out.println("1) Golf");
            System.out.println("2) Football");
            choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.println("Welcome to Stabelford golf scoring system.");
                    System.out.print("Enter the number of strokes");
                    int strokes = sc.nextInt();
                    System.out.print("Enter the par for the goal");
                    int par = sc.nextInt();
                    int score = strokes - par;
                    System.out.println(stabelford.get(score) + "Point value is - " + Math.abs(score - 2));
                }
                case 2 -> {
                    System.out.println("Welcome to football scoring system.");
                    System.out.println("Let's analyze the performance of the player by PDO - ");
                    System.out.print("Enter the number of saves - ");
                    double saves = sc.nextInt();
                    System.out.print("Enter the number of shots - ");
                    double shots = sc.nextInt();
                    System.out.print("Enter the number of goals - ");
                    double goals = sc.nextInt();
                    double savePercentage = Math.round(saves / shots * 100);
                    double shootingPercentage = Math.round(goals / shots * 100);
                    double pdo = savePercentage + shootingPercentage;
                    System.out.println("Soccer scoring results - " + ".");
                    System.out.println("The save percentage is - " + savePercentage);
                    System.out.println("THe shooting percentage is - " + shootingPercentage +".");
                    System.out.println("The PDO score is - " + pdo +"%.");
                    if (pdo > 100) {
                        System.out.println("The football team is performing better than they except and they are due for a bad luck streak.");
                        break;
                    }
                    System.out.println("The football team is performing worse than they except and they are due for a good luck streak.");
                }
                default -> {
                    System.out.println("Enter correct option.");
                }
            }
        } while (choice != 1 && choice != 2);
    }
}