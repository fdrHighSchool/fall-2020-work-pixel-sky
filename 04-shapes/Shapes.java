import java.lang.Math;

public class Shapes {
    public static void main(String[] args) {
        rectangle(10, 20);
        square(10);
        triangle(10, 10);
        triangle(10, 10, 10);
        circle(10);
    }

    public static void rectangle (double height, double width) {
        System.out.printf("the area is: %f\n", height * width);
    }

    public static void square (double side) {
        rectangle(side, side);
    }

    public static void triangle (double height, double base) {
        rectangle(height, base / 2);
    }

    public static void triangle (double a, double b, double c) {
        double s = (a + b + c) / 2;
        double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
        System.out.printf("the area is: %f\n", area);
    }

    public static void circle (double radius) {
        System.out.printf("the area is: %f\n", Math.PI * Math.pow(radius, 2));
    }
}
