import java.util.Scanner;

public class Main {
    static final String USERNAME = "electraArts";
    static final String PASSWORD = "electra@2022";

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Welcome to electra Artisans System");
        System.out.println("Enter for :\n1) Administrator \n2)Customer\n-");
        int option = sc.nextInt();
        switch (option) {
            case 1 -> {
                System.out.print("Enter Username : ");
                String username = sc.next();
                System.out.print("Enter Password : ");
                String password = sc.next();
                if (username.equals(USERNAME) && password.equals(PASSWORD)) {
                    administrator();
                }
                System.out.print("Enter correct credentials and retry from start.");
                System.exit(0);
            }
            case 2 -> {
                customer();
            }
        }
    }

    private static void customer() {
        System.out.println("Welcome Customer, please select the traditional arts section : \n1) Mexican\n2)Bolivian");
        int option = sc.nextInt();
        switch (option) {
            case 1 -> {
                System.out.println("The mexican traditional uses lots of  vibrant colours and tells story of ancient cultures of mexican people.");
            }
            case 2 -> {
                System.out.println("The bolivian traditional uses lots of beige colours and tells story of ancient kings and rulers of bolivian people living there.");
            }
            default -> {
                System.out.print("Enter correct credentials and retry from start.");
                System.exit(0);
            }
        }
    }

    private static void administrator() {
        System.out.println("Login successful!\nWelcome administrator");
        System.out.println("Please select for analyzing :\n1) Cost of Goods Computation(COGS)\n2) Profit Margin\n3) Six Sigma Value ");
        int option = sc.nextInt();
        switch (option) {
            case 1 -> {
                System.out.println("Cost of goods sold (COGS)");
                System.out.print("Enter the beginning inventory price :");
                int begInventory = sc.nextInt();
                System.out.print("Enter the beginning inventory price :");
                int purchasePrice = sc.nextInt();
                System.out.print("Enter the beginning inventory price :");
                int endInventory = sc.nextInt();
                int cogs = begInventory + purchasePrice - endInventory;
                System.out.println("The cost of goods sold for your business is " + cogs + ".");
            }
            case 2 -> {
                System.out.println("Profit Margin");
                System.out.print("Enter the net income :");
                double netIncome = sc.nextDouble();
                System.out.print("Enter the revenue :");
                double revenue = sc.nextDouble();

                double profitMargin = netIncome / revenue * 100;
                System.out.println("The profit margin is : " + profitMargin + ".");
            }
            case 3 -> {
                double sixSigma = 1.0;
                System.out.println("Six sigma value");
                System.out.print("Defects : ");
                double defects = sc.nextDouble();
                System.out.print("Opportunity per unit :");
                double opp = sc.nextDouble();
                System.out.print("Enter number of units :");
                int n = sc.nextInt();
                double dpo = defects / (opp * n);

                double yield = (1 - dpo) * 100;
                if (yield >= 99.99) {
                    sixSigma = 6;
                } else if (yield >= 99.97) {
                    sixSigma = 5;
                } else if (yield >= 99.38) {
                    sixSigma = 4;
                } else if (yield >= 99.33) {
                    sixSigma = 3;
                } else if (yield >= 69.10) {
                    sixSigma = 2;
                }
                System.out.println("Six Sigma value is " + sixSigma);
            }
            default -> {
                System.out.println("Enter correct option and restart the system");
                System.exit(0);
            }
        }
        System.exit(1);
    }
}