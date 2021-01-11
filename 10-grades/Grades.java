import java.util.*;

public class Grades{
    public static void main(String[] args) {
        // create Scanner object
        Scanner scanner = new Scanner(System.in);

        // ask the user for how many grades they want to enter
        System.out.print("How many grades do you want to enter? ");
        int numGrades = scanner.nextInt();

        // setup an Array to be used and filled with the user's input
        int arr[] = new int[numGrades];

        /*
        --------------------
        |    |    |    |    |
        ---------------------
        */
        // looping structure to get multiple values from the user
        for (int i = 0; i < numGrades; i++){
            // get next int and store to a variable
            // insert into the next slot in the Array
            System.out.print("Enter in the grade: ");
            arr[i] = scanner.nextInt();

        }
        // display the contents of the Array, to check that everything worked
        System.out.println(Arrays.toString(arr));

        // get the mean of the grades
        System.out.println(mean(arr));
        // get the median of the grades
        System.out.println(median(arr));
        // get the mode of the grades
        System.out.println(mode(arr).toString());

        scanner.close();
    }//end main method

    // The mean is found by adding all numbers in the data set and then dividing by the number of values in the set.
    public static double mean(int[] arr) {
        double sum = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum / arr.length;
    }

    // The median is the middle value when a data set is ordered from least to greatest.
    public static double median(int[] arr) {
        arr = sort(arr);
        // if there are even number of elements in the array
        if (arr.length % 2 == 0) {
            // return the average of the middle 2 number
            return (arr[arr.length / 2 - 1] + arr[arr.length / 2]) / 2.0;
        }
        // if not
        else {
            // return the middle number
            return arr[arr.length / 2];
        }
    }

    // The mode is the number that occurs most often in a data set.
    public static ArrayList<Integer> mode(int[] arr) {
        arr = sort(arr);
        ArrayList<Integer> mostOften = new ArrayList<Integer>();
        int currentNum = arr[0];    // the current number being compared
        int highest = 0;            // keep track of how many time the most often number occure
        int count = 0;              // keep track of how many time the current number occure

        // time complexity O(n)
        for (int i: arr) {
            // if it encounters a new number 
            if (i != currentNum) {
                // if the count is more than highest
                if (count > highest) {
                    mostOften.clear();      // clear the array list
                    highest = count;        // new highest
                }
                // if count is not less than highest 
                if (!(count < highest)) {
                    mostOften.add(currentNum);  // add the currrent number
                    currentNum = i;             // new current number  
                    count = 1;                  // reset count
                } 
            }
            // if it is the same numebr 
            else {
                // increase the count
                count++;
            }
        }

        if (count > highest) {mostOften.clear();}
        if (!(count < highest)) {mostOften.add(currentNum);}

        // return the arrayList of the modes in the array
        return mostOften;
    }

    // really basic sorting algorithm
    public static int[] sort(int[] array) {
        while (true) {
            boolean sorted = true;  // at the start of each sort, sorted = true
            for (int i = 0; i < array.length - 1; i++) {
                // if not sorted
                if (array[i] > array[i + 1]) {
                    // swap
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    
                    // if there is a pair of number not in order then sorted = false
                    sorted = false;
                }
            }
            if (sorted)         // if there are no number that is not sorted 
                return array;   // return the sorted array
        }    
    }
}