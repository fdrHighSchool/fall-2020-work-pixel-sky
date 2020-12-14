public class SelfDivisor {
    public static void main(String[] args) {
        System.out.println(isSelfDivisor(128));
        for (int num : firstNumSelfDivisors(10, 3)) {
            System.out.println(num);
        }
    }

    /**
     * 
     * @param number the number to be tested
     *          Precondition: number > 0
     * @return true if every decimal digit of number is a divisor of number;
     *          false otherwise
     */
    public static boolean isSelfDivisor(int number) {
        String num = Integer.toString(number);
        for (int i = 0; i < num.length(); i++) {
            int digit = Character.getNumericValue(num.charAt(i));
            if (digit == 0) {
                return false;
            }
            if (number % digit != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 
     * @param start starting point for valuse to be checked
     * @param num the size fo the arry to be returned
     * @return an array containing the first numm integers >= start that are self-divisors.
     */
    public static int[] firstNumSelfDivisors(int start, int num) {
        int[] numbers = new int[num];
        int count = 0;

        while (count != num) {
            if (isSelfDivisor(start)) {
                numbers[count++] = start;
            }
            start++;
        }

        return numbers;
    }
}