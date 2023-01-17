import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // Telescope details
        System.out.println("Important information regarding telescopes:");
        System.out.println("A longer focal ratio is great or observing satellites, planets and nearby stars.");
        System.out.println("A smaller focal ratio is great or observing clusters, galaxies and local groups.");
        System.out.println();
        Telescope telescope1 = new Telescope("The Skywatcher Evostar 120(90°)", 1000, 102);
        Telescope telescope2 = new Telescope("The Celestron Starhopper ", 1270, 250);
        System.out.println("The telescopes in this facility are :");
        System.out.println("Telescope name - focal ratio - telescope description");
        System.out.println(telescope1.getName() + " - " + telescope1.getFocalRatio() + " - " + telescope1.telescopeDescription());
        System.out.println(telescope2.getName() + " - " + telescope2.getFocalRatio() + " - " + telescope2.telescopeDescription());

        // Space Explorer aage and weight
        System.out.println("Age and weight calculation in other planets");
        System.out.print("Enter your current age : ");
        double age = sc.nextInt();
        System.out.print("Enter your current weight : ");
        double weight = sc.nextDouble();
        SpaceExplorer spaceExplorer = new SpaceExplorer(age, weight);

        System.out.println("Space exploration details : ");
        System.out.println("Planet Name - Planet type - Planet age - Planet weight");
        System.out.println("Mercury - Terrestrial - " + spaceExplorer.getMercuryExplorerDetails());
        System.out.println("Venus - Terrestrial - " + spaceExplorer.getVenusExplorerDetails());
        System.out.println("Mars - Terrestrial - " + spaceExplorer.getMarsExplorerDetails());
        System.out.println("Jupiter - Gas giant/Brown dwarf - " + spaceExplorer.getJupiterExplorerDetails());
        System.out.println("Saturn - Gas giant - " + spaceExplorer.getSaturnExplorerDetails());
        System.out.println("Uranus - Ice giant - " + spaceExplorer.getUranusExplorerDetails());
        System.out.println("Neptune - Ice giant - " + spaceExplorer.getNeptuneExplorerDetails());
    }
}
