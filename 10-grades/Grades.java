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
        System.out.println(mode(arr));

        scanner.close();
    }//end main method

    // The mean is found by adding all numbers in the data set and then dividing by the number of values in the set.
    public static double mean(int[] arr){
        double sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        return sum / arr.length;
    }

    // The median is the middle value when a data set is ordered from least to greatest.
    public static int median(int[] arr) {
        arr = sort(arr);
        if (arr.length % 2 == 0) {
            return (arr[arr.length / 2] + arr[arr.length / 2 + 1]) / 2;
        }
        else {
            return arr[arr.length / 2 + 1];
        }
    }

    // The mode is the number that occurs most often in a data set.
    public static int mode(int[] arr) {
        return 0;
    }

    // really basic sorting algorithm
    public static int[] sort(int[] array) {
        while (true) {
            boolean sorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                // if not sorted
                if (array[i] > array[i + 1]) {
                    // swap
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    
                    sorted = false;
                }
            }
            if (sorted)
                return array;
        }    
    }
}