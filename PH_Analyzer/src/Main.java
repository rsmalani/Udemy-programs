import java.util.*;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);

            System.out.println(ANSI_Colors.RED_BRIGHT);
            System.out.println("|\"");
            System.out.println("| \"");
            System.out.println("|  \"");
            System.out.println("|   \"");
            System.out.println("|    \"");
            System.out.println("|     \"");
            System.out.println("|      \"");
            System.out.println("|       \"");
            System.out.println("|        \"");
            System.out.println("|---------\"");
            System.out.println(ANSI_Colors.RESET+"Are you ready to begin(Yes or No)?");
            String response=sc.nextLine();

            while(response.equalsIgnoreCase("Yes"))
            {
                System.out.println(ANSI_Colors.BLUE_BOLD_BRIGHT+"Which side of the right angle triangle would you like to find?\nA.Hypotenuse\nB.Perpendicular\nC.Opposite\n");
                String side_choice=sc.nextLine();

                switch (side_choice) {
                    case "A" -> {
                        System.out.println(ANSI_Colors.RESET + "Enter the length of the perpendicular side of the right angle");
                        double perpen_len = sc.nextDouble();
                        System.out.println("Enter the length of opposite side of the right angle");
                        double opp_len = sc.nextDouble();
                        double hypot = Math.hypot(perpen_len, opp_len);
                        System.out.println(ANSI_Colors.GREEN_BOLD + "The length of hypotenuse is " + hypot);
                    }
                    case "B" -> {
                        System.out.println(ANSI_Colors.RESET + "Enter the length of the hypotenuse of the right angle triangle");
                        double hypo_len = sc.nextDouble();
                        System.out.println("Enter the length of opposite side of the right angle triangle");
                        double opp_len2 = sc.nextDouble();
                        double perpen_len2 = Math.sqrt(Math.pow(hypo_len, 2) - Math.pow(opp_len2, 2));
                        System.out.println("length of perpendicular side is " + perpen_len2);
                    }
                    case "C" -> {
                        System.out.println(ANSI_Colors.RESET + "Enter the length of the hypotenuse of the right angle triangle");
                        double hypo_len2 = sc.nextDouble();
                        System.out.println("Enter the length of the perpendicular side of the right angle triangle");
                        double perpen_len3 = sc.nextDouble();
                        double calculate_opplen = Math.sqrt(Math.pow(hypo_len2, 2) - Math.pow(perpen_len3, 2));
                        System.out.println("length of perpendicular side is " + calculate_opplen);
                    }
                    default -> System.out.println(ANSI_Colors.RED_BOLD + "Sorry,you have entered en incorrect option!");
                }

                System.out.println(ANSI_Colors.RESET+"Are you ready to begin(Yes or No)?");
                response=sc.nextLine();
            }

            if(response.equalsIgnoreCase("No"))
            {
                System.out.println("Okay,have a great day!");
            }
    }
}