import java.util.*;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JFrame;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main extends Canvas{
    static String randomElement;
    static int randomIndex;
    static String randomElement2;
    static int randomIndex2;
    static String randomElement3;
    static int randomIndex3;
    static String customer_choice;
    static String gift;
    static int gift_no;
    static double gift_price = 4.5;
    static double orangeBlossom = 12;
    static double cinnamon = 11.50;
    static double pistachio = 13.50;
    static double price;
    static double totalCookiePrice = 0;

    public void paint(Graphics g)
    {
        Toolkit t = Toolkit.getDefaultToolkit();
        if (customer_choice.equals("1")) {
            Image i = t.getImage("‪C:\\images for programs\\pic2.png");
            g.drawImage(i,50,100,this);
        } else if (customer_choice.equals("2")) {
            Image k = t.getImage("‪C:\\images for programs\\gift.png");
            g.drawImage(k,50,100,this);
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner text = new Scanner(System.in);
        Scanner number = new Scanner(System.in);
        Main m = new Main();
        JFrame f = new JFrame();
        f.add(m);
        f.setSize(1100,800);
        Rectangle pageSize = new Rectangle(650,650);
        pageSize.setBackgroundColor(BaseColor.CYAN);
        Document document = new Document(pageSize);
        PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\pc dell\\Downloads\\Health+Programming+Lesson_Materials\\cookie.pdf"));

        List<String> pos_list = new ArrayList<>();
        pos_list.add("excellent");
        pos_list.add("great");
        pos_list.add("brilliant");
        Random r = new Random();
        for (int i = 0; i < pos_list.size(); i++) {
            randomIndex = r.nextInt(pos_list.size());
        }
        randomElement = pos_list.get(randomIndex);

        List<String> list2 = new ArrayList<>();
        list2.add("Who is this lucky person in your family");
        list2.add("Family members are special!");
        Random r2 = new Random();
        for (int i = 0; i < list2.size(); i++) {
            randomIndex2 = r2.nextInt(list2.size());
        }
        randomElement2 = list2.get(randomIndex2);

        List<String> list3 = new ArrayList<>();
        list3.add("Your friend is so lucky! ");
        list3.add("This person must be dear to you!");
        Random r3 = new Random();
        for (int i = 0; i < list3.size(); i++) {
            randomIndex = r3.nextInt(pos_list.size());
        }
        randomElement3 = list3.get(randomIndex3);

        System.out.println(Colors.PURPLE_BOLD_BRIGHT);
        System.out.println("+-------------------------------------+");
        System.out.println("|                                     |");
        System.out.println("|                                     |");
        System.out.println("|    Welcome to the cookie treats     |");
        System.out.println("|      enjoy delicious pastries,      |");
        System.out.println("|      All the way from Morocco       |");
        System.out.println("|                                     |");
        System.out.println("|                                     |");
        System.out.println("+------------------------------------*/");

        System.out.println(Colors.RED_BOLD_BRIGHT + "😃 Hello, dear customer what is your name?");
        String name = text.nextLine();
        Thread.sleep(1000);
        System.out.println("😃 Welcome, " + name +"my name is dj the moroccan bot");
        Thread.sleep(1000);
        System.out.println("😃 I am here to help you purchase your order");
        Thread.sleep(2000);
        System.out.println("Would you like to view the principal menu? (Yes or No)");
        String response = text.nextLine();
        while (response.equals("Yes")) {
            System.out.println(Colors.GREEN_BOLD_BRIGHT);
            System.out.println("+-----------------------------------+");
            System.out.println("| 1.View pastries                   |");
            System.out.println("| 2.Buy a gift box	                |");
            System.out.println("| 3.Order pastries       	  		|");
            System.out.println("| 4.Finalize Order                  |");
            System.out.println("+----------------------------------*/");
            customer_choice = text.nextLine();
            switch (customer_choice) {
                case "1" -> {
                    System.out.println(Colors.RESET + "😃 That is " + randomElement + ",please have a look at the cookies we have for sale!");
                    Thread.sleep(4000);
                    f.setVisible(true);
                    Thread.sleep(3000);
                    f.dispose();
                    Thread.sleep(2000);
                    System.out.println("😃 Please have a look at our cookies men below");
                    Thread.sleep(2000);
                    System.out.println(Colors.CYAN_BOLD_BRIGHT);
                    System.out.println("------------- Maroc Pastries Menu -------------");
                    System.out.println("|      1. Almond Orange Blossom Cookies		  |");
                    System.out.println("|      2. Cinnamon Nut Flavored Cookies		  |");
                    System.out.println("|      3. Pistachio Rose Water Cookies		  |");
                    System.out.println("------------- Maroc Pastries Menu -------------");
                    Thread.sleep(2000);
                }
                case "2" -> {
                    System.out.println(Colors.BLUE_BOLD_BRIGHT + "😃 Oh wow, would you like to buy  gift for a:-\n1.Family member\n2.Friend ?");
                    String user = text.nextLine();
                    Thread.sleep(2000);
                    if (user.equals("1")) {
                        System.out.println("😃 " + randomElement2);
                    } else if (user.equals("2")) {
                        System.out.println("😃 " + randomElement3);
                    }
                    Thread.sleep(2000);
                    System.out.println("😃 Have a look at the gift boxes we sell and choose one before placing an order");
                    Thread.sleep(3000);
                    f.setVisible(true);
                    Thread.sleep(5000);
                    f.dispose();
                    System.out.println(Colors.ROSY_PINK + "😃 Which gift package would you like to purchase?\n1.Gift Box A \n2.Gift Box 2 \n3.GiftBox 3");
                    String gift_choice = text.nextLine();
                    switch (gift_choice) {
                        case "1" -> {
                            gift = "Gift Box A";
                            System.out.println("😃 How many of this type of gift box would you like? ");
                            gift_no = number.nextInt();
                            gift_price = gift_price * gift_no;
                        }
                        case "2" -> {
                            gift = "Gift Box B";
                            System.out.println("😃 How many of this type of gift box would you like? ");
                            gift_no = number.nextInt();
                            gift_price = gift_price * gift_no;
                        }
                        case "3" -> {
                            gift = "Gift Box C";
                            System.out.println("😃 How many of this type of gift box would you like? ");
                            gift_no = number.nextInt();
                            gift_price = gift_price * gift_no;
                        }
                    }
                    System.out.println(Colors.RESET + "😃 Please return back to the main menu to complete your order");
                    Thread.sleep(2000);
                }
                case "3" -> {
                    document.open();
                    Font titlefont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 30, BaseColor.RED);
                    document.add(new Paragraph("Moroccan Cookies Invoice\n", titlefont));
                    com.itextpdf.text.Image image2 = com.itextpdf.text.Image.getInstance("C:\\Users\\pc dell\\Downloads\\Health+Programming+Lesson_Materials\\Health Programming Lesson_Materials\\Pictures\\logo2.png");
                    image2.setAbsolutePosition(550, 550);
                    document.add(image2);
                    document.add(new Paragraph("\n"));
                    String customer_intro = "Customer Name:- " + name;
                    document.add(new Paragraph(customer_intro));
                    document.add(new Paragraph("\n"));
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    Date date = new Date();
                    String dates = "Dates Of Order:- " + formatter.format(date);
                    document.add(new Paragraph(dates));
                    document.add(new Paragraph("\n"));
                    document.add(new Paragraph("Cookie Name(s)\t\t\t\t| Quantity\\t\t\t\t| Price($)\n"));
                    System.out.println(Colors.BLUE_BOLD_BRIGHT + "😃 We are happy to hear that you would like to place your order " + name);
                    Thread.sleep(2000);
                    System.out.println("😃 How many Cookies would you like to order?");
                    int cookie_no = number.nextInt();   //5
                    for (int y = 0; y < cookie_no; y++) {
                        System.out.println("😃 Which cookie would you like to order? (Almond Orange, Cinnamon Nut, Pistachio Rose)");
                        String cookie = text.nextLine();
                        System.out.println(Colors.RESET + "How many of this cookie would you like to order?");
                        double cookie_no2 = number.nextDouble();
                        switch (cookie) {
                            case "Almond Orange" -> price = orangeBlossom * cookie_no2;
                            case "Cinnamon Nut" -> price = cinnamon * cookie_no2;
                            case "Pistachio Rose" -> price = pistachio * cookie_no2;
                            default -> {
                                System.out.println("😃 Sorry you have entered an incorrect option!, restart the system again");
                                System.exit(0);
                            }
                        }
                        totalCookiePrice = totalCookiePrice + price;
                        String order = cookie + "\t\t\t\t\t " + cookie_no2 + " \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t " + price;
                        document.add(new Paragraph(order));
                    }
                }
                case "4" -> {
                    System.out.println(Colors.GREEN_BOLD_BRIGHT);
                    System.out.println("😃 " + name + "your order has noe been finalized");
                    Thread.sleep(2000);
                    System.out.println("😃 Did you select any gift option(Y or N)?");
                    String gift_option = text.nextLine();
                    if (gift_option.equals("Y")) {
                        document.add(new Paragraph("\n"));
                        String total_price = "\t\t\t\t\t\t\t\t\t\t Total Cookies Price($) = " + totalCookiePrice;
                        document.add(new Paragraph(total_price));
                        document.add(new Paragraph("\n"));
                        document.add(new Paragraph("Gift Box Type\t\t\t\t| Quantity\t\t\t\t| Price($)\n"));
                        String gifts = gift + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t " + gift_no + " \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t " + gift_price;
                        document.add(new Paragraph(gifts));
                        document.add(new Paragraph("\n"));
                        document.close();
                    } else if (gift_option.equals("N")) {
                        gift = "Not Required";
                        gift_no = 0;
                        gift_price = 0;
                        document.add(new Paragraph("\n"));
                        String total_price = "\t\t\t\t\t\t\t\t\t\t Total Cookies Price($) = " + totalCookiePrice;
                        document.add(new Paragraph(total_price));
                        document.add(new Paragraph("\n"));
                        document.add(new Paragraph("Gift Box Type\t\t\t\t| Quantity\t\t\t\t| Price($)\n"));
                        String gifts = gift + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t " + gift_no + " \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t " + gift_price;
                        document.add(new Paragraph(gifts));
                        document.add(new Paragraph("\n"));
                        document.close();
                    }
                }
            }
            System.out.println("Would you like to view the principal menu? (Yes or No)");
            response = text.nextLine();
        }
    }
}