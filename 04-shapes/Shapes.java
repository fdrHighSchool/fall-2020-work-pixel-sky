import java.lang.Math;

public class Shapes {
    public static void main(String[] args) {
        double area;
        // 2 dimension area and 3 dimension volume

        // rectangle
        area = rectangle(10, 20);
        System.out.printf("2d: %f, 3d: %f\n", area, threeD(5, area));

        // square
        area = square(10);
        System.out.printf("2d: %f, 3d: %f\n", area, threeD(5, area));

        // triangle
        area = triangle(10, 10);
        System.out.printf("2d: %f, 3d: %f\n", area, threeD(5, area));

        // another triangle
        area = triangle(10, 10, 10);
        System.out.printf("2d: %f, 3d: %f\n", area, threeD(5, area));

        // circle
        area = circle(10);
        System.out.printf("2d: %f, 3d: %f\n", area, threeD(5, area)); 
    }

    public static double rectangle (double height, double width) {
        return height * width;
    }

    public static double square (double side) {
        return rectangle(side, side);
    }

    public static double triangle (double height, double base) {
        return rectangle(height, base) / 2;
    }

    public static double triangle (double a, double b, double c) {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    public static double circle (double radius) {
        return Math.PI * Math.pow(radius, 2);
    }

    public static double threeD (double depth, double area) {
        return depth * area;
    }
}
