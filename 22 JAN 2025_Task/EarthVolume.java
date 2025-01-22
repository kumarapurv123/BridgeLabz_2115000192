public class EarthVolume {
    public static void main(String[] args) {
        double rad_Km = 6378;
        double pi = 3.14159265359;
        double vol_Km3 = (4.0 / 3.0) * pi * Math.pow(rad_Km, 3);
        double CF = 1.609344;// conversion factor
        double vol_Miles3 = vol_Km3 / Math.pow(CF, 3);
        System.out.println("The volume of Earth in cubic kilometers is " + vol_Km3 +
                " and in cubic miles is " + vol_Miles3);
    }
}
