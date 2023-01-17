public class Telescope {
    private final int focalLength;
    private final int aperture;
    private final String name;

    private double focalRatio;

    public Telescope(String name, int focalLength, int aperture) {
        this.name = name;
        this.focalLength = focalLength;
        this.aperture = aperture;
    }

    public double getFocalRatio() {
        focalRatio = (double) focalLength / aperture;
        return focalRatio;
    }

    public String getName() {
        return name;
    }

    public String telescopeDescription() {
        if (focalRatio > 7) {
            return "This telescope is great for observing satellites, planets and close stars.";
        }
        return "This telescope is great for observing clusters, galaxies and local groups.";
    }


}