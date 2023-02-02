import java.util.*;
import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;

import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.lowagie.text.*;
import com.google.zxing.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class Main {
    static String TSI_status;
    static double total_specimen = 0, total_product = 0, HBI;
    static String secchi;
    static String TSI_new;
    static String HBI_new;
    static DecimalFormat dc;
    static String water_bodyname;
    static StringBuilder qr_result;
    static Date current_date;
    static String HBI_status;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        current_date = new Date();
        dc = new DecimalFormat("#.##");

        System.out.println("Welcome to the water body health analyzer");
        System.out.println(Colors.GREEN_BOLD_BRIGHT + "Question : A grandfather, two fathers and two sons went to the movie and bought one ticket each.\nHow many tickets did they buy in total?(type your answers in letters)");
        System.out.println(Colors.HIDDEN);
        String user_answer = sc.nextLine();
        while (!user_answer.equals("three")) {
            System.out.println(Colors.GREEN_BOLD_BRIGHT + "Question : A grandfather, two fathers and two sons went to the movie and bought one ticket each.\nHow many tickets did they buy in total?(type your answers in letters)");
            System.out.println(Colors.HIDDEN);
            user_answer = sc.nextLine();
        }
        System.out.println(Colors.RESET + "You can now use this program.");
        System.out.println("How many water body areas would you like to analyze?");
        int water_bodies = sc.nextInt();
        System.out.println("Please enter the location of where you would like to store your results");
        String pdf = sc.nextLine();
        OutputStream fos = new FileOutputStream(new File(pdf));
        Document document = new Document(PageSize.A4.rotate());
        PdfWriter writer = PdfWriter.getInstance(document, fos);
        PdfPTable table = new PdfPTable(5);
        float[] widths = {3,3,3,3,3};
        table.setWidths(widths);
        PdfPCell cell = new PdfPCell(new Phrase("Water Body Name"));
        cell.setBackgroundColor(Color.CYAN);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Water Body Type"));
        cell.setBackgroundColor(Color.CYAN);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Sechhi Depth(meters)"));
        cell.setBackgroundColor(Color.CYAN);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("TSI(Secchi Depth"));
        cell.setBackgroundColor(Color.CYAN);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Hilsenhoff Biotic Index(HBI)"));
        cell.setBackgroundColor(Color.CYAN);
        table.addCell(cell);
        Phrase ph;
        qr_result = new StringBuilder();
        document.open();
        Font font = FontFactory.getFont(FontFactory.TIMES,18f);
        document.add(new Paragraph("The Water Body Health Analyzer Results",font));
        document.add(new Paragraph("\n"));
        document.add(new Paragraph(current_date.toString()));
        document.add(new Paragraph("\n"));
        document.add(new Paragraph("Detailed Results : "));
        document.add(new Paragraph("\n"));
        for (int i = 1; i < water_bodies + 1 ; i++) {
            System.out.println("Enter the name of water body");
            water_bodyname = sc.nextLine();
            System.out.println("Enter the water body type (river, lake, ocean, etc)");
            String water_type = sc.nextLine();
            System.out.println("Enter the extinction depth (m)");
            double extinction_depth = sc.nextDouble();
            System.out.println("Enter the eruption depth (m)");
            double erupt_depth = sc.nextDouble();
            double secchi_depth = (extinction_depth + erupt_depth)/2;
            secchi = dc.format(secchi_depth);
            double TSI = 60 - 1441 * Math.log(secchi_depth);
            TSI_new = dc.format(TSI);
            if (TSI >= 0 && TSI <= 40)
                TSI_status = "Oligotropic";
            if (TSI > 40 && TSI <= 50)
                TSI_status = "Mesotropic";
            if (TSI > 50)
                TSI_status = "Eutropic";

            System.out.println(Colors.BLUE_BOLD_BRIGHT + "HBI is ");
            System.out.println(Colors.RESET + "How many species did you sample in this area?");
            int species = sc.nextInt();

            for (int j = 0; j < species; j++) {
                System.out.println("Enter the tolerance value of species " + (j + 1));
                double tolerance = sc.nextDouble();
                System.out.println("Enter the number of specimens sampled for species " + (j + 1));
                double specimen = sc.nextDouble();
                double product = tolerance * specimen;
                total_specimen += specimen;
                total_product += product;
                HBI = total_product/total_specimen;
            }

            HBI_new = dc.format(HBI);
            if (HBI >= 0 && HBI <= 3.75)
                HBI_status = "Water quality is excellent, organic pollution is unlikely.";
            else if (HBI >= 3.75 && HBI <= 4.25)
                HBI_status = "Water quality is very good, possible slight organic pollution.";
            else if (HBI >= 4.26 && HBI <= 5)
                HBI_status = "Water quality is very good, some organic pollution is probable.";
            else if (HBI >= 5.01 && HBI <= 5.76)
                HBI_status = "Water quality is fair, fairly substantial organic pollution is likely.";
            else if (HBI >= 5.76 && HBI <= 6.5)
                HBI_status = "Water quality is fairly poor, some organic pollution is probable.";
            else if (HBI >= 6.51 && HBI <= 7.25)
                HBI_status = "Water quality is poor, very substantial organic pollution is likely.";
            else if (HBI >= 7.26 && HBI <= 10)
                HBI_status = "Water quality is very poor, severe organic pollution is likely.";

            cell = new PdfPCell();
            ph = new Phrase(water_bodyname);
            cell.addElement(ph);
            table.addCell(cell);

            cell = new PdfPCell();
            ph = new Phrase(water_type);
            cell.addElement(ph);
            table.addCell(cell);

            cell = new PdfPCell();
            ph = new Phrase(secchi);
            cell.addElement(ph);
            table.addCell(cell);

            cell = new PdfPCell();
            ph = new Phrase(TSI_new);
            cell.addElement(ph);
            table.addCell(cell);

            cell = new PdfPCell();
            ph = new Phrase(HBI_new);
            cell.addElement(ph);
            table.addCell(cell);

            document.add(new Paragraph("The tropic state index result for area " + i + "is " + TSI_status));
            document.add(new Paragraph("\n"));
            document.add(new Paragraph("The Hilsenhoff Biotic Index(HBI) result for area " + i + "is " + HBI_status));
            document.add(new Paragraph("\n"));

            if(i == water_bodies + 1) {
                document.add(table);
            }

            String results = "Water body name is - " + water_bodyname +
                    "\n The secchi depth in meters is - " + secchi +
                    "\n The tropic state index is - " + TSI_new +
                    "\n The HBI index is - " + HBI_new +
                    "\n";
            qr_result.append(results);
        }

        System.out.println("Thank you");
        generateQRCode(qr_result.toString());
        document.close();
        writer.close();
    }

    private static void generateQRCode(String text) throws Exception {
        QRCodeWriter qc = new QRCodeWriter();
        BitMatrix bm = qc.encode(text, BarcodeFormat.QR_CODE, 1250, 1250);
        String path = "C:\\Users\\pc dell\\Downloads\\Materials_Programming+++Mathematics+++Water+Science+++Education+++Health\\Lesson 20 Materials\\Program Run Results\\result.png";
        MatrixToImageWriter.writeToFile(bm, "PNG", new File(path));
    }
}