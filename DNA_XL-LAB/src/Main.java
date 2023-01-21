import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Do you want to initiate the System (Yes or No)");
        String str = sc.nextLine();
        while (str.equalsIgnoreCase("yes")) {
            System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT + "Welcome to the XL DNA analysis!");
            System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT);
            System.out.println("O       o O       o O       o");
            System.out.println("| O   o | | O   o | | O   o |");
            System.out.println("| | O | | | | O | | | | O | |");
            System.out.println("| o   O | | o   O | | o   O |");
            System.out.println("o       O o       O o       O");

            System.out.println(ConsoleColors.RESET + "Enter the first DNA strand");
            String _DNA_1 = sc.nextLine();
            System.out.println("Enter the second DNA strand");
            String _DNA_2 = sc.nextLine();

            if (_DNA_1.length() != _DNA_2.length()) {
                System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "The DNA strands do not match.");
                System.exit(0);
            }

            int hammingDistance = 0;
            System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT + "The DNA strands match.");
            for (int i = 0; i < _DNA_1.length(); i++) {
                if (_DNA_1.charAt(i) == _DNA_2.charAt(i))
                    continue;
                hammingDistance++;
            }
            System.out.println(ConsoleColors.RESET + "The hamming distance of the two input DNA strands is " + hammingDistance + ".");

            System.out.println("\n\nDo you want to initiate the System (Yes or No)");
            str = sc.nextLine();
        }
        System.out.println("Thank you, Good bye!");
    }
}