import java.lang.Math;
import java.util.Scanner;

public class Distance {

    public static void main(String[] args) {
        //get two points from the user (x, y)
        //ex: (3, 5)...stored as a String
        Scanner s = new Scanner(System.in);
    
        System.out.print("Enter point 1: ");
        String point1 = s.nextLine();
    
        System.out.print("Enter point 2: ");
        String point2 = s.nextLine();
    
    
        System.out.printf("The distance between %s and %s is...\n", point1, point2);
        //parse, meaning, get ints from String, the information from the inputs
        //(3, 4) --> x1 = 3, y1 = 4
    
        int x1 = getX(point1);
        int x2 = getX(point2);
        int y1 = getY(point1);
        int y2 = getY(point2);
        
        //send data to methods to calculate distance
        
        System.out.printf("cartesianDistance: %f\n", cartesianDistance(x1, y1, x2, y2));
        System.out.printf("taxicabDistance: %f\n", taxicabDistance(x1, y1, x2, y2));
    
        /*
        TEST CASES:
        (0, 0) & (3, 4) --> cartesianDistance = 5, taxicabDistance = 7
        (0, 0) & (5, 12) --> cartesianDistance = 13, taxicabDistance = 17
        Do negative coordinates work? If not, how would you go about fixing that?
        */
    
        s.close();
    }//end main

    /*
    * N: cartesianDistance
    * P: determine the distance between any two points on x/y axis (diagonal)
    * I: pass in x1, y1, x2, y2
    * R: the result of the distance formula: sqrt((x2 - x1)^2 + (y2 - y1)^2)
    */
    public static double cartesianDistance(double x1, double y1, double x2, double y2) {
        double distance = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
        return distance;
    }//end cartesianDistance


    /*
    * N: taxicabDistance
    * P: determine the distance between any two points on x/y axis (grid)
    * I: pass in x1, y1, x2, y2
    * R: the result of the distance formula: abs(x2 - x1) + abs(y2 - y1)
    */
    public static double taxicabDistance(double x1, double y1, double x2, double y2) {
        double distance = Math.abs(x2 - x1) + Math.abs(y2 - y1);
        return distance;
    }//end cartesianDistance

    public static int getX(String point) {
        //locate the comma
        int comma = point.indexOf(",");
    
        //we know the x-value in the String starts at index 1
        //we now know where the comma is
        //so, the x-value is from index 1 to the location of the comma
        String x = point.substring(1, comma);
    
        return Integer.parseInt(x);
    }//end getX method

    public static int getY(String point) {
        //locate the comma
        int comma = point.indexOf(",");

        //we know the y-value in the String starts at index 2 afther comma
        //we now know where the comma is
        //so, the y-value is from index comma + 2 to the location of the the end of the string - 1
        String y = point.substring(comma + 2, point.length() - 1);

        return Integer.parseInt(y);
    }
}//end class
