/* 
    project: https://github.com/fdrHighSchool/fall-2020-CSA/tree/master/projects/fraction-calculator
*/

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
            
            if (!expression.equals("exit"))
                System.out.println(produceAnswer(expression));
            else
                event = false;
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

        //System.out.println(toStr(parseExpression(values[2]));
        
        // Checkpoint 3: Evaluate the formula and return the result as a fraction.
        //               Example "4/5 * 1_2/4" returns "6/5".

        //for (int i = 0; i < values.length; i = i + 2) {
        //    System.out.println(toStr(parseExpression(values[i])));
        //}
        
        //System.out.println(toStr(mixingFraction(reduce(addition(parseExpression(values[0]), parseExpression(values[2]))))));
        //System.out.println(toStr(mixingFraction(reduce(subtraction(parseExpression(values[0]), parseExpression(values[2]))))));
        //System.out.println(toStr(mixingFraction(reduce(multiplication(parseExpression(values[0]), parseExpression(values[2]))))));
        //System.out.println(toStr(mixingFraction(reduce(division(parseExpression(values[0]), parseExpression(values[2]))))));

        //               Note: Answer does not need to be mixingFractiond, but it must be correct.
        // Final project: All answers must be mixingFractiond.
        //               Example "4/5 * 1_2/4" returns "1_1/5".

        int[] result;

        // runs at least once, if there are only 2 numbers
        if (values[1].equals("+"))
            result = reduce(addition(parseExpression(values[0]), parseExpression(values[2])));
        else if (values[1].equals("-")) 
            result = reduce(subtraction(parseExpression(values[0]), parseExpression(values[2])));
        else if (values[1].equals("*")) 
            result = reduce(multiplication(parseExpression(values[0]), parseExpression(values[2])));
        else 
            result = reduce(division(parseExpression(values[0]), parseExpression(values[2])));
        
        // if there are more that 2 numbers, start at the third number; third number have index of 4
        for (int i = 4; i < values.length; i = i + 2) {
            // check for the operator before the number
            if (values[i - 1].equals("+"))
                result = reduce(addition(result, parseExpression(values[i])));
            else if (values[i - 1].equals("-")) 
                result = reduce(subtraction(result, parseExpression(values[i])));
            else if (values[i - 1].equals("*")) 
                result = reduce(multiplication(result, parseExpression(values[i])));
            else 
                result = reduce(division(result, parseExpression(values[i])));
        }

        return toStr(mixingFraction(result));
    }//end produceAnswer method

    // TODO: Fill in the space below with helper methods

    // parse expression
    public static int[] parseExpression(String value) {
        // gets the index of _
        int underscoreIndex = value.indexOf("_");
        // gets the index of /
        int divideIndex = value.indexOf("/");

        int whole = 0;          // whole number default 0
        int numerator = 0;      // numerator default 0
        int denominator = 1;    // denominator default 1

        // if there are underscore
        if (underscoreIndex != -1)
            // whole number equal to from 0 to underscore
            whole = Integer.parseInt(value.substring(0, underscoreIndex));
        // elseif there are no underscore
        else if (divideIndex == -1)
            // whole number equal to value[i]
            whole = Integer.parseInt(value);

        // don't parse fraction if there are no fraction
        if (divideIndex != -1) {
            // from underscore +1 to division symbol
            numerator = Integer.parseInt(value.substring(underscoreIndex + 1, divideIndex));
            // from the division symbol +1 to the end
            denominator = Integer.parseInt(value.substring(divideIndex + 1));
        }
    
        // if the whole number is negative then the numerator would also be negative
        if (whole < 0) 
            numerator = numerator * -1;

        // create int array
        int[] numbers = {whole, numerator, denominator};

        // return mixed fraction
        return numbers;
    }

    // addition
    public static int[] addition(int[] num1, int[] num2) {
        int[] result = new int[3];
        result[0] = 0;
        
        // operate on improper fraction
        num1[1] = improperingFraction(num1);
        num2[1] = improperingFraction(num2);

        // if the denominator is the same
        if (num1[2] == num2[2]) {
            // numerator = numerator - numerator
            result[1] = num1[1] + num2[1];    // a - c
            // denominator is the same
            result[2] = num1[2];
        }
        else {
            // numerator = (numerator1 * denominator2) - (denominator1 * numerator2)
            result[1] = (num1[1] * num2[2]) + (num2[1] * num1[2]);    // a * d - b * c
            // denominator = denominator1 * denominator2
            result[2] = num2[2] * num1[2];    // b * d
        }

        // return improper fraction
        return result;
    }
    
    // subtraction
    public static int[] subtraction(int[] num1, int[] num2) {
        int[] result = new int[3];
        result[0] = 0;

        // operate on improper fraction
        num1[1] = improperingFraction(num1);
        num2[1] = improperingFraction(num2);

        // if the denominator is the same
        if (num1[2] == num2[2]) {
            // numerator = numerator - numerator
            result[1] = num1[1] - num2[1];    // a - c
            // denominator is the same
            result[2] = num1[2];
        }
        else {
            // numerator = (numerator1 * denominator2) - (denominator1 * numerator2)
            result[1] = (num1[1] * num2[2]) - (num2[1] * num1[2]);    // a * d - b * c
            // denominator = denominator1 * denominator2
            result[2] = num2[2] * num1[2];    // b * d
        }

        // return improper fraction
        return result;
    }

    // multiplication
    public static int[] multiplication(int[] num1, int[] num2) {
        int[] result = new int[3];
        result[0] = 0;

        // numerator times numerator
        result[1] = improperingFraction(num1) * improperingFraction(num2);    // a * c
        // denominator times denominator
        result[2] = num1[2] * num2[2];    // b * d
        
        // return improper fraction
        return result;
    }

    // division
    public static int[] division(int[] num1, int[] num2) {
        int[] result = new int[3];
        result[0] = 0;

        // cross multiply
        result[1] = improperingFraction(num1) * num2[2];    // a * d
        result[2] = num1[2] * improperingFraction(num2);    // b * c

        // return improper fraction
        return result;
    }

    public static int improperingFraction(int[] num) {
        return num[0] * num[2] + num[1];
    }

    // reduce the numerator and the denominator of the fraction
    public static int[] reduce(int[] num) {
        // get the gcd of the 2 number
        int gcd = greatestCommonDivisor(num[1], num[2]);

        // reduce
        num[1] = num[1] / gcd;
        num[2] = num[2] / gcd;

        return num;
    }

    // turn the improper fraction into mixed fraction
    public static int[] mixingFraction(int[] num) {
        // -/- = +
        if (num[1] < 0 && num[2] < 0) {
            num[1] = Math.abs(num[1]);
            num[2] = Math.abs(num[2]);
        }

        // whole = numerator / denominator
        num[0] = num[1] / num[2];
        // numerator = remainder of numerator / denominator
        num[1] = num[1] % num[2];

        return num;
    }

    // turn the int array into string
    public static String toStr(int[] values) {
        // if the fraction is 0
        if (values[1] == 0) {
            // return only the whole number
            return Integer.toString(values[0]);
        }
        // if the whole number is 0
        else if(values[0] == 0) {
            // return only the fraction
            return String.format("%d/%d", values[1], values[2]);
        }
        // else return mixed fraction
        return String.format("%d_%d/%d", values[0], values[1], values[2]);
    }
    
    /**
     * greatestCommonDivisor - Find the largest integer that evenly divides two integers.
     *      Use this helper method in the Final Checkpoint to mixingFraction fractions.
     * @param a - First integer.
     * @param b - Second integer.
     * @return The GCD.
     */
    public static int greatestCommonDivisor(int a, int b) {
        /* Euclidean algorithm
         *  takes the bigger of number a and b and mod it with the smaller one, to get a remainder
         *  take the previous smaller number and mod it against previous remainder, to get a new remainder
         *  take the previous smaller number and mod it against previous remainder, to get another remainder
         *  continues until the remainder is equal to 0
         * 
         *  Example: gcm(12, 44) = 44(bigger numebr) % 12(smaller number) = 8(remainder)
         *                       = 12(previous smaller number) % 8(previous remainder) = 4(new remainder)
         *                       = 8(previous smaller number) % 4(previous remainder) = 0(new remainder)
         *                       last remainder that is not 0 is 4, gcm = 4
         */
        a = Math.abs(a);
        b = Math.abs(b);

        // change position if b > a
        if (b > a) {
            int temp = a;
            a = b;
            b = temp;
        }

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
    public static int leastCommonMultiple(int a, int b) {
        return 0;
    }//end leastCommonMultiple

}//end class