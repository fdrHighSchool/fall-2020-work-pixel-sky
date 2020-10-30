import java.util.Scanner;

public class Bill {
    public static void main(String[] args){

		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to the Bill-Splitter");

        System.out.print("Enter the total, pre-tax: ");
		double total = input.nextDouble();

        System.out.print("how much tax (in decimal):");
        double tax = input.nextDouble();
        total = (1 + tax) * total;
        
        System.out.print("how much tips:");
        double tips = input.nextDouble();
        total += tips;

		System.out.print("How many people? ");
		int numPeople = input.nextInt();

        double perPerson = total / numPeople;

		System.out.println("Each person must pay $" + perPerson + ", incuding tip");

        input.close();
	}//end main method    
}
