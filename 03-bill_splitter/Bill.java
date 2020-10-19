import java.util.Scanner;

public class bill {
    public static void main(String[] args){

		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to the Bill-Splitter");

        System.out.print("Enter the total, pre-tax: ");
		double total = input.nextInt();

        System.out.print("how much tax:");
        double tax = input.nextDouble();
        total = (1 + tax) * total;
        
        System.out.print("how much tips:");
        double tips = input.nextInt();
        total += tips;

		System.out.print("How many people? ");
		int numPeople = input.nextInt();

        double perPerson = total / numPeople;

		System.out.println("Each person must pay $" + perPerson + ", plus tip");

        input.close();
	}//end main method    
}
