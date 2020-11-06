import java.util.Scanner;

public class FracCalc {

    /**
     * Prompts user for input, passes that input to produceAnswer, then outputs the result.
     * @param args - unused
     */
    public static void main(String[] args){
        // TODO: Read the input from the user and call produceAnswer with an equation
        // Checkpoint 1: Create a Scanner, read one line of input, pass that input to produceAnswer, print the result.
        Scanner input = new Scanner(System.in);
        //System.out.printf("Enter a expression: ");
        //String expression = input.nextLine();

        //System.out.println(produceAnswer(expression));
        // Checkpoint 2: Accept user input multiple times.
        boolean event = true;
        while (event) {
            System.out.printf("Enter a expression: ");
            String expression = input.nextLine();
            
            if (!expression.equals("quit")) {
                System.out.println(produceAnswer(expression));
            }
            else {
                event = false;
            }
        }
        input.close();
    }//end main method

    /**
     * produceAnswer - This function takes a String 'input' and produces the result.
     * @param expression - A fraction string that needs to be evaluated.  For your program, this will be the user input.
     *      Example: input ==> "1/2 + 3/4"
     * @return the result of the fraction after it has been calculated.
     *      Example: return ==> "1_1/4"
     */
    public static String produceAnswer(String expression){
        // TODO: Implement this function to produce the solution to the input
        // Checkpoint 1: Return the second operand.  Example "4/5 * 1_2/4" returns "1_2/4".
        String[] values = expression.split(" ");

        //System.out.println(values[2]);

        // Checkpoint 2: Return the second operand as a string representing each part.
        //               Example "4/5 * 1_2/4" returns "whole:1 numerator:2 denominator:4".
        // gets the index of _
        int underscoreIndex = values[2].indexOf("_");
        // gets the index of /
        int divideIndex = values[2].indexOf("/");

        // from beginning to underscore
        int whole = underscoreIndex != -1 ? Integer.parseInt(values[2].substring(0, underscoreIndex)) : 0;
        // from underscore +1 to division symbol
        int numerator = Integer.parseInt(values[2].substring(underscoreIndex + 1, divideIndex));
        // from the division symbol +1 to the end
        int denominator = Integer.parseInt(values[2].substring(divideIndex + 1));
    
        String numbers = String.format("%d+%d/%d", whole, numerator, denominator);
        System.out.printf(numbers);
        // Checkpoint 3: Evaluate the formula and return the result as a fraction.
        //               Example "4/5 * 1_2/4" returns "6/5".

        //               Note: Answer does not need to be reduced, but it must be correct.
        // Final project: All answers must be reduced.
        //               Example "4/5 * 1_2/4" returns "1_1/5".


        return numbers;
    }//end produceAnswer method

    // TODO: Fill in the space below with helper methods

    /**
     * greatestCommonDivisor - Find the largest integer that evenly divides two integers.
     *      Use this helper method in the Final Checkpoint to reduce fractions.
     * @param a - First integer.
     * @param b - Second integer.
     * @return The GCD.
     */
    public static int greatestCommonDivisor(int a, int b){
        /* Euclidean algorithm
            takes the bigger of number a and b and mod it with the smaller one, to get a remainder
            take the previous smaller number and mod it against the remainder, to get a new remainder
            take the previous smaller number and mod it against the new remainder, to get another remainder
            continues until the remainder is equal to 0

            Example: gcm(12, 44) = 44(bigger numebr) % 12(smaller number) = 8(remainder)
                                 = 12(previous smaller number) % 8(previous remainder or the smaller number) = 4(new remainder)
                                 = 8(previous smaller number) % 4(previous remainder or the smaller number) = 0(new remainder)
                                 last remainder that is not 0 is 4, gcm = 4
        */
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }//end greatestCommonDivisor method

    /**
     * leastCommonMultiple - Find the smallest integer that can be evenly divided by two integers.
     *      Use this helper method in Checkpoint 3 to evaluate expressions.
     * @param a - First integer.
     * @param b - Second integer.
     * @return The LCM.
     */
    public static int leastCommonMultiple(int a, int b){
        return 0;
    }//end leastCommonMultiple

}//end class
