import java.util.*;
import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.text.DecimalFormat;

public class Main extends Canvas {
    static double x_root1, x_root2, determinant;
    static JFrame test = new JFrame();
    static String option_choice;
    static int a, b;

    public void paint(Graphics g)
    {
        g.setColor(Color.white);
        g.setFont(new Font("Times New Roman", Font.BOLD, 40));
        g.drawOval(20, 5, 800, 300);
        DecimalFormat df = new DecimalFormat("#.#");
        String ans_1 = df.format(x_root1);
        String ans_2 = df.format(x_root2);
        if(option_choice.equals("A")){
            g.drawString("The x values are :- " + ans_1 + ", " + ans_2 + ".",150,150);

        }
        else if(option_choice.equals("B")) {
            if(determinant > 0.0 ) {
                double root_1 = (-b + Math.pow(determinant , 0.5)) / (2.0 * a);
                double root_2 = (-b - Math.pow(determinant , 0.5)) / (2.0 * a);
                g.drawString("The Roots are :- " + df.format(root_1)+ ", " + df.format(root_2) + ".",150,150);


            }
            else if(determinant == 0.0 ) {
                double root_1 = -b/(2.0 * a);
                g.drawString("The Roots is :- " + root_1 + ".",150,150);

            }
            else {
                g.drawString("There Are no real roots.", 150,150);

            }
        }
    }
    public static void main(String[] args) throws Exception {
        Main draw = new Main();
        test.getContentPane().setBackground(Color.BLACK);
        test.setSize(900,400);
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Scanner numbers = new Scanner(System.in);
        Scanner text = new Scanner(System.in);

        System.out.print(Colors.BLUE_BOLD_BRIGHT +"Are you ready to begin(Y - Yes N - NO) - ");
        String user_input = text.nextLine();
        while (user_input.equals("Y"))
        {
            System.out.println(Colors.RED_BOLD_BRIGHT + "Welcome to the quadratic root finder program");
            System.out.println(Colors.CYAN_BOLD_BRIGHT + "Choose one of the options : \nA.Find the roots of a quadratic equation by factorization\nB.Find the roots of a quadratic equation by formula");
            String user_response = text.nextLine();
            if (user_response.equals("A"))
            {
                option_choice = "A";
                System.out.print(Colors.BLACK_BOLD_BRIGHT + "Enter the ac value (enter as a positive value) - ");
                int number = numbers.nextInt();

                System.out.print("Is the ac value is positive or negative (type any one of the options) - ");
                String response = text.nextLine();
                System.out.print(Colors.BLACK_BOLD_BRIGHT + "Enter the ac value -");
                int val;
                if (response.equals("negative"))
                {
                    val = -numbers.nextInt();
                } else {
                    val = numbers.nextInt();
                }

                int val_b;
                System.out.print("Is the b value is positive or negative (type any one of the options) - ");
                response = text.nextLine();
                System.out.print(Colors.CYAN_BOLD +"Enter the b value - ");
                if (response.equals("negative"))
                {
                    val_b = -numbers.nextInt();
                } else {
                    val_b = numbers.nextInt();
                }

                for (int i = 1; i <= number; i++) {
                    if(number % i == 0) {
                        if((-(number / i) + i == val_b) && (-(number / i) * i == val)) {
                            System.out.println("The factors are :- " + "-" + (number / i) + " " + i +".");
                            System.out.print(" Enter The a Value - ");
                            double a = numbers.nextInt();
                            x_root1 = -1 * (-((float) number / i) / a);
                            x_root2 = -1 *(i / a);
                            break;

                        }

                        else if((i + (number / i)  == val_b) && ((i) *  (-number / i) == val)) {
                            System.out.println("The factors are :- " +  i + " " + (number / i) + ".");
                            System.out.print(" Enter The a Value  - ");
                            double a = numbers.nextInt();
                            x_root1 = -1 * (((float) number / i) / a);
                            x_root2 = -1 *(i / a);
                            break;
                        }
                        else if((-i - (number / i)  == val_b) && ((-i) * (-number / i) == val)) {
                            System.out.println("The factors are :- " +  " - " + i + " " + "-" + (number / i) + ".");
                            System.out.print(" Enter The a Value - ");
                            double a = numbers.nextInt();
                            x_root1 = -1 * (-((float) number / i) / a);
                            x_root2 = -1 * (-i / a);
                            break;
                        }
                    }
                }

            } else if (user_response.equals("B")){
                option_choice = "B";
                System.out.print("Enter The a value of the equation - ");
                double a = numbers.nextDouble();
                System.out.print("Enter The b value of the Equation - ");
                double b = numbers.nextDouble();
                System.out.print("Enter The c value of the Equation - ");
                double c = numbers.nextDouble();
                determinant = b * b - 4.0 * a * c;
                x_root1 = (0 - b - determinant) / (2 * a);
                x_root2 = (0 - b + determinant) / (2 * a);
            }

            test.add(draw);
            test.setVisible(true);
            Thread.sleep(10000);
            test.dispose();

            System.out.print(Colors.BLUE_BOLD_BRIGHT +"Are you ready to begin (Y - Yes N - NO) - ");
            user_input  = text.nextLine();
        }
        if (user_input.equals("N")) {
            System.out.println("Okay.Thank You!!");
        }
    }
}
		