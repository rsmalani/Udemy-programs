import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        String str = "Yes";
        do {
            System.out.println("Welcome to the Highland BanK ATM");
            System.out.println("Would you like to continue (Yes or No)");
            str = sc.nextLine();
            if (str.equalsIgnoreCase("no"))
                break;

            System.out.println("Enter Username");
            String username = sc.nextLine();
            System.out.println("Enter Password");
            String password = sc.nextLine();

            BankUserList list = new BankUserList();
            BankUser bankUser = list.getBankUser(username, password);
            if (bankUser == null) {
                System.out.println("Enter correct credentials");
                System.exit(0);
            }

            int choice;
            do {
                System.out.println("What would you like to do?");
                System.out.println("1) Balance");
                System.out.println("2) Deposit");
                System.out.println("3) Withdrawal");
                System.out.println("4) Exit");
                System.out.print("Enter your choice : ");
                choice = sc.nextInt();
                if (choice < 1 || choice > 4) {
                    System.out.println("Enter correct choice and we will restart system.");
                    continue;
                }
                if (choice == 4) {
                    break;
                }

                switch (choice) {
                    case 1 -> {
                        System.out.println("The account balance is - " + bankUser.getBalance() + ".");
                    }
                    case 2 -> {
                        System.out.println("Enter the amount to be deposited - ");
                        int deposit = sc.nextInt();
                        bankUser.addBalance(deposit);
                        System.out.println("Your new balance is - " + bankUser.getBalance());
                    }
                    case 3 -> {
                        System.out.println("Enter the amount to be debited - ");
                        int debit = sc.nextInt();
                        if (bankUser.getBalance() < debit) {
                            System.out.println("Entered amount is higher than balance.");
                            System.out.println("Please try again.");
                            continue;
                        }
                        bankUser.addBalance(- debit);
                        System.out.println("Your new balance is - " + bankUser.getBalance());
                    }
                }
            } while (choice > 0 && choice < 4);

            System.out.println("Would you like to continue (Yes or No)");
            str = sc.nextLine();
        } while (str.equalsIgnoreCase("yes"));
        System.out.println("Thank you for banking with us.");
    }
}