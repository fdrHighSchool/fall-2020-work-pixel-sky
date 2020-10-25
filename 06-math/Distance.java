import java.lang.Math;

public class Distance {

    public static void main(String[] args) {
        System.out.println(cartesianDistance(0, 3, 4, 0));
        System.out.println(taxicabDistance(0, 3, 4, 0));
    }

    public static double cartesianDistance(double x1, double y1, double x2, double y2) {
        double distance = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
        return distance;
    }

    public static double taxicabDistance(double x1, double y1, double x2, double y2) {
        double distance = Math.abs(x2 - x1) + Math.abs(y2 - y1);
        return distance;
    }
}