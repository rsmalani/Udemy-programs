import java.util.Scanner;

public class Main {
    static int multiply, multiply1;
    static int sum_even = 0, sum_odd = 0, track = 0;
    static int sum_even1 = 0, sum_odd1 = 0, track1 = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Are you ready to begin (Yes or No)?");
        String user_response = sc.nextLine();
        if (!user_response.equals("Yes")) {
            System.out.println("Thank you, Good bye");
            System.exit(0);
        }
        do {
            System.out.println(Console_Colors.YELLOW_BOLD_BRIGHT);
            System.out.println("       .--.           .---.        .-.");
            System.out.println("   .---|--|   .-.     | A |  .---. |~|    .--.");
            System.out.println(".--|===|Ch|---|_|--.__| S |--|:::| |~|-==-|==|---.");
            System.out.println("|%%|NT2|oc|===| |~~|%%| C |--|   |_|~|CATS|  |___|-.");
            System.out.println("|  |   |ah|===| |==|  | I |  |:::|=| |    |GB|---|=|");
            System.out.println("|  |   |ol|   |_|__|  | I |__|   | | |    |  |___| |");
            System.out.println("|~~|===|--|===|~|~~|%%|~~~|--|:::|=|~|----|==|---|=|");
            System.out.println("^--^---'--^---^-^--^--^---'--^---^-^-^-==-^--^---^-'");
            System.out.print(Console_Colors.RESET + "Enter 12 digit ISBN number :");
            String isbn = sc.nextLine();
            if (isbn.length() != 12) {
                System.out.println("You have entered incorrect ISBN number.");
                System.exit(0);
            }
            for (int i = 0; i < isbn.length(); i++) {
                char s = isbn.charAt(i);
                track++;
                if (track % 2 == 0) {
                    multiply = 3 * (sum_even = sum_even + Character.getNumericValue(s));
                } else {
                    sum_odd += Character.getNumericValue(s);
                }
            }
            int remainder = (sum_odd + multiply) % 10;
            int check_digit = 10 - remainder;
            System.out.println(Console_Colors.GREEN_BOLD_BRIGHT + "The check digit is : " + check_digit + ".");

            // Verifying the isbn 13th digit
            System.out.print(Console_Colors.RESET + "Enter 12 digit ISBN number :");
            String isbn13 = sc.nextLine();
            if (isbn13.length() != 13) {
                System.out.println("You have entered incorrect ISBN number.");
                System.exit(0);
            }
            for (int i = 0; i < isbn13.length(); i++) {
                char s = isbn13.charAt(i);
                track1++;
                if (track1 % 2 == 0) {
                    multiply1 = 3 * (sum_even1 = sum_even1 + Character.getNumericValue(s));
                } else {
                    sum_odd1 += Character.getNumericValue(s);
                }
            }
            int remainder1 = (sum_odd1 + multiply1) % 10;
            if (remainder1 == 0)
                System.out.println(Console_Colors.BLUE_BOLD_BRIGHT + "The given ISBN number is valid.");
            else
                System.out.println(Console_Colors.RED_BOLD_BRIGHT + "The given ISBN number is invalid.");

            System.out.println(Console_Colors.RESET + "\n\nAre you ready to begin (Yes or No)?");
            user_response = sc.nextLine();
            if (!user_response.equals("Yes")) {
                System.out.println("Thank you, Good bye");
                System.exit(0);
            }
        } while (true);
    }
}