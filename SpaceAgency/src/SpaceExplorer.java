public class SpaceExplorer {
    private double age;
    private double weight;

    SpaceExplorer(double age, double weight) {
        this.age = age;
        this.weight = weight;
    }

    public String getMercuryExplorerDetails() {
        double nage = age * 365 / 88;
        double nweight = weight * 0.38;
        return "Age in mercury : " + nage + " - Weight in mercury : " + nweight;
    }

    public String getVenusExplorerDetails() {
        double nage = age * 365 / 225;
        double nweight = weight * 0.91;
        return "Age in mercury : " + nage + " - Weight in mercury : " + nweight;
    }

    public String getMarsExplorerDetails() {
        double nage = age * 365 / 687;
        double nweight = weight * 0.38;
        return "Age in mercury : " + nage + " - Weight in mercury : " + nweight;
    }

    public String getJupiterExplorerDetails() {
        double nage = age / 12;
        double nweight = weight * 2.34;
        return "Age in mercury : " + nage + " - Weight in mercury : " + nweight;
    }

    public String getSaturnExplorerDetails() {
        double nage = age / 30;
        double nweight = weight * 1.06;
        return "Age in mercury : " + nage + " - Weight in mercury : " + nweight;
    }

    public String getUranusExplorerDetails() {
        double nage = age / 84;
        double nweight = weight * 0.92;
        return "Age in mercury : " + nage + " - Weight in mercury : " + nweight;
    }

    public String getNeptuneExplorerDetails() {
        double nage = age / 165;
        double nweight = weight * 1.19;
        return "Age in mercury : " + nage + " - Weight in mercury : " + nweight;
    }
}
