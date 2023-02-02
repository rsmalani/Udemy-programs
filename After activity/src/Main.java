import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.*;
import javax.swing.*;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

public class Main extends Canvas{
    static String days_choice;
    static String club_choice;
    static String club_time;
    static String club_venue;
    static Date current_Date;
    static int Scienceclub_stats = 0;
    static int Artclub_stats = 0;
    static int Bookclub_stats = 0;
    static int Dramaclub_stats = 0;
    static int Charityclub_stats = 0;
    static int Mathclub_stats = 0;
    static int Historyclub_stats = 0;
    static int Sportsclub_stats = 0;
    static int Codingclub_stats = 0;
    static Document document;
    static PdfWriter writer;

    public void paint(Graphics g) {
        Image activity = new ImageIcon("C:\\Users\\pc dell\\Downloads\\Materials_Programming+++Mathematics+++Water+Science+++Education+++Health\\Lesson 20 Materials\\Picture Example\\Picture2.png").getImage();
        g.drawImage(activity,0,0,this);
    }

    public static void main(String[] args) throws Exception {
        Scanner text = new Scanner(System.in);
        Scanner number =  new Scanner(System.in);
        JFrame test = new JFrame();
        Main obj = new Main();
        test.setSize(680,690);
        test.add(obj);
        test.setVisible(true);
        current_Date = new Date();

        System.out.println(Colors.GREEN_BOLD_BRIGHT + "Welcome to the after school activity registration portal");;
        System.out.println(Colors.RESET);

        System.out.println("+------------+--------------+------------+");
        System.out.println("|Mon/Tue     |  Wed         | Thu/Fri    |");
        System.out.println("+------------+--------------+------------+");
        System.out.println("|Science club| Drama club   |History club|");
        System.out.println("|Art club    | Charity club |Sport club  |");
        System.out.println("|Book club   | Math club    |Coding club |");
        System.out.println("+------------+--------------+------------+");

        System.out.println("Are you ready to begin using the system(sure or Not now)");
        String user_response = text.nextLine();
        do {

            //Administrator login details

            String admin_authusername = "xxx";
            String admin_authpassword = "xxx";

            System.out.println(Colors.BLUE_BOLD_BRIGHT + "Are you an Administrator or student(type in your answer)");
            String response = text.nextLine();

            if(response.equals("Administrator")) {
                System.out.println(Colors.RESET + "Enter the administrator username");
                String admin_username = text.nextLine();
                System.out.println("Enter the administrator password");
                String admin_password = text.nextLine();
                while(!admin_username.equals(admin_authusername) || !admin_password.equals(admin_authpassword)) {
                    System.out.println(Colors.RED_BOLD_BRIGHT + "Sorry, You have entered incorrect details!, please rentered you information again ");
                    System.out.println(Colors.RESET + "Enter the administrator username");
                    admin_username = text.nextLine();
                    System.out.println("Enter the administrator password");
                    admin_password = text.nextLine();
                }

                if(admin_username.equals(admin_authusername) && admin_password.equals(admin_authpassword)) {
                    String file_path = "C:\\Users\\pc dell\\Downloads\\Materials_Programming+++Mathematics+++Water+Science+++Education+++Health\\Lesson 20 Materials\\";
                    System.out.println(Colors.CYAN_BOLD_BRIGHT + "Enter the name of the student's file you will like to find");
                    String student_name = text.nextLine();
                    String complete_filename = file_path + student_name + ".pdf";
                    Path path = Paths.get(complete_filename, null);
                    if (Files.exists(path, null) && !Files.isDirectory(path, null)) {
                        System.out.println(Colors.RESET + "File is found!");
                        PdfReader reader;
                        try {
                            reader = new PdfReader(complete_filename);
                            String textfrompage = PdfTextExtractor.getTextFromPage(reader,1);
                            System.out.println(textfrompage);
                            reader.close();

                        } catch(IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println(Colors.RED_BOLD_BRIGHT + "Sorry the file is does not exist!");
                    }
                }
            } else if(response.equals("Student")) {

            }

            System.out.println(Colors.RESET +"How many after school activity club would you like to register for(Max is 3 clubs)?");
            int club_number = number.nextInt();
            while(club_number >= 1 && club_number <= 3) {
                System.out.println("Please enter the file location where you would like to store the information for the after acticities that you have registered for? ");
                String pdfFilePath = text.nextLine();
                System.out.println("Enter your name");
                String student_name = text.nextLine();
                OutputStream fos = new FileOutputStream(new File(pdfFilePath));
                document = new Document(PageSize.A4.rotate());
                writer = PdfWriter.getInstance(document, fos);
                PdfPTable table = new PdfPTable(4);
                float widths[] = {3,3,3,3};
                table.setWidths(widths);
                PdfPCell cell = new PdfPCell(new Phrase("Club Name"));
                cell.setBackgroundColor(Color.GREEN);
                table.addCell(cell);
                cell = new PdfPCell(new Phrase("Club Day(s)"));
                cell.setBackgroundColor(Color.GREEN);
                table.addCell(cell);
                cell = new PdfPCell(new Phrase("Club Time"));
                cell.setBackgroundColor(Color.GREEN);
                table.addCell(cell);
                cell = new PdfPCell(new Phrase("Club Venue"));
                cell.setBackgroundColor(Color.GREEN);
                table.addCell(cell);
                Phrase ph;
                document.open();
                String Student_nameupdate = student_name + "s Afternoon Activity Record";
                Font fontSize_18 = FontFactory.getFont(FontFactory.TIMES,18f);
                document.add(new Paragraph(Student_nameupdate, fontSize_18));
                document.add(new Paragraph("\n"));
                document.add(new Paragraph(current_Date.toString()));
                document.add(new Paragraph("\n"));
                for (int r=1; r<=club_number; r++)
                {
                    System.out.println(Colors.CYAN_BOLD_BRIGHT + "What day(s) would you like to register for(Mon/Tue, wed , Thu/Fri)");
                    days_choice = text.nextLine();

                    if(days_choice.equals("Mon/Tue"))
                    {
                        days_choice = "Mon/Tue";
                        System.out.println("Which club would you like to register for(Science Club or Art club or Book club)?");
                        club_choice = text.nextLine();
                        if(club_choice.equals("Science club"))
                        {
                            Scienceclub_stats = Scienceclub_stats + 1;
                            club_time = "3:30 pm to 4:30 pm";
                            club_venue = "Outdoor hall 1";
                        } else if(club_choice.equals("Art club"))
                        {
                            Artclub_stats = Artclub_stats + 1;
                            club_time = "3:30 pm to 4:30 pm";
                            club_venue = "Outdoor hall 2";
                        } else if(club_choice.equals("Book club"))
                        {
                            Bookclub_stats = Bookclub_stats + 1;
                            club_time = "3:30 pm to 4:30 pm";
                            club_venue = "Outdoor hall 3";
                        } else {
                            System.out.println(Colors.RED_BOLD_BRIGHT + "Sorry, you have written an incorrect option! ");
                        }
                    } else if(days_choice.equals("Wed")) {
                        days_choice = "Wed";
                        System.out.println(Colors.RESET + "Which club would you like to register for(Drama club or Charity club or Math club)?");
                        club_choice = text.nextLine();
                        if(club_choice.equals("Drama club"))
                        {
                            Dramaclub_stats = Dramaclub_stats + 1;
                            if(Dramaclub_stats > 1)
                            {
                                Dramaclub_stats = Dramaclub_stats - 1;
                                System.out.println(Colors.RED_BOLD_BRIGHT + "Sorry you cannot register for drama club more than once!");
                            } else {
                                club_time = "3:40 pm to 4:40 pm";
                                club_venue = "Outdoor hall 4";
                                continue;
                            }
                        } else if(club_choice.equals("Charity club")) {
                            Charityclub_stats = Charityclub_stats + 1;
                            if(Charityclub_stats > 1)
                            {
                                Charityclub_stats = Charityclub_stats - 1;
                                System.out.println(Colors.RED_BOLD_BRIGHT + "Sorry you cannot register for charity club more than once!");
                            } else {
                                club_time = "3:40 pm to 4:40 pm";
                                club_venue = "Outdoor hall 5";
                                continue;
                            }
                        } else if(club_choice.equals("Math club"))
                        {
                            Mathclub_stats = Mathclub_stats + 1;
                            if(Mathclub_stats > 1)
                            {
                                Mathclub_stats = Mathclub_stats - 1;
                                System.out.println(Colors.RED_BOLD_BRIGHT + "Sorry you cannot register for math club more than once!");
                            } else
                            {
                                club_time = "3:40 pm to 4:40 pm";
                                club_venue = "Outdoor hall 6";
                                continue;
                            }
                        } else {
                            System.out.println(Colors.RED_BOLD_BRIGHT + "Sorry, you have written an incorrect option! ");
                        }
                    } else if(days_choice.equals("Thu/Fri"))
                    {
                        days_choice = "Thu/Fri";
                        System.out.println(Colors.BLUE_BOLD_BRIGHT + "Which club would you like to register for(History Club or Sport club or Coding club)?");
                        club_choice = text.nextLine();
                        if(club_choice.equals("History club"))
                        {
                            Historyclub_stats = Historyclub_stats + 1;
                            club_time = "3:40 pm to 4:40 pm";
                            club_venue = "Outdoor hall 7";
                        } else if(club_choice.equals("Sport club"))
                        {
                            Sportsclub_stats = Sportsclub_stats + 1;
                            club_time = "3:40 pm to 4:40 pm";
                            club_venue = "Field";
                        } else if(club_choice.equals("Coding club"))
                        {
                            Codingclub_stats = Codingclub_stats + 1;
                            club_time = "3:20 pm to 4:20 pm";
                            club_venue = "Computer Lab 1";
                        } else {
                            System.out.println(Colors.RED_BOLD_BRIGHT + "Sorry, you have written an incorrect option! ");
                        }
                    } else {
                        System.out.println("Sorry you have entered an incorrect option!");
                    }

                    cell = new PdfPCell();
                    ph = new Phrase(club_choice);
                    cell.addElement(ph);
                    table.addCell(cell);

                    cell = new PdfPCell();
                    ph = new Phrase(days_choice);
                    cell.addElement(ph);
                    table.addCell(cell);

                    cell = new PdfPCell();
                    ph = new Phrase(club_time);
                    cell.addElement(ph);
                    table.addCell(cell);

                    cell = new PdfPCell();
                    ph = new Phrase(club_venue);
                    cell.addElement(ph);
                    table.addCell(cell);

                    if(r==club_number)
                    {
                        document.add(table);
                    }
                }
                document.close();
                writer.close();

                System.out.println(Colors.RESET +"How many after school activity club would you like to register for(Max is 3 clubs)?");
                club_number = number.nextInt();
            }

            System.out.println("Are you ready to begin using the system(Now or Not now)");
            user_response = text.nextLine();

        }while(user_response.equals("Sure"));
        if(user_response.equals("Not now"))
        {
            DefaultPieDataset dataset = new DefaultPieDataset();
            dataset.setValue("Science club", Scienceclub_stats);
            dataset.setValue("Art club", Artclub_stats);
            dataset.setValue("Book club", Bookclub_stats);
            dataset.setValue("Drama club", Dramaclub_stats);
            dataset.setValue("Charity club", Charityclub_stats);
            dataset.setValue("Math club", Mathclub_stats);
            dataset.setValue("History club", Historyclub_stats);
            dataset.setValue("Sport club", Sportsclub_stats);
            dataset.setValue("Coding club", Codingclub_stats);
            JFreeChart chart = ChartFactory.createPieChart("Afterschool Activiies", dataset, true, true, true);
            PiePlot p = (PiePlot)chart.getPlot();
            ChartFrame frame = new ChartFrame("Statistics", chart);
            frame.setVisible(true);
            frame.setSize(500,500);
            System.out.println("Thank you for registering!");
        }
    }
}