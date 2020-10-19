import java.util.Scanner;

public class temperature {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("to which unit (celcus/fahrenheit): ");
        String unit = input.nextLine();
        if (unit.equals("celcus")) {
            System.out.print("degree: ");
            double temp = input.nextInt();
            System.out.printf("%.1f", fTOc(temp));
        }
        else {
            System.out.print("degree: ");
            double temp = input.nextInt();
            System.out.printf("%.1f", cTOf(temp));
        }
        input.close();
    }    
    // Celcus to Fahrenheit 
    public static double cTOf(double celcus) {
        return (celcus * 9/5) + 32;
    }

    // Fahrenheit to Celcus
    public static double fTOc(double fahrenheit) {
        return (fahrenheit - 32) * 5/9;
    }
}
