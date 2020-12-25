import java.util.Arrays;

class grades2D {
    public static void main(String[] args) {
        final int ROWS = 30;
        final int COLUMNS = 10;

        int[][] grades = populate2DArray(ROWS, COLUMNS);    // create a 2D array
        
        displayValues(grades);                              // print the grades

        double[] averages = getAverages(grades);            // get the average of all student
        double[] sortedAverages = sort(averages);           // get the sorted average of all student

        System.out.println(Arrays.toString(averages));
        System.out.println(Arrays.toString(sortedAverages));

        System.out.printf("The highest average is: %f\n", sortedAverages[sortedAverages.length - 1]);         // print the valedictorian
        System.out.printf("The second highest average is: %f\n", sortedAverages[sortedAverages.length - 2]);  // print the salutatorian
    }

    // fill and return an 2D array
    public static int[][] populate2DArray(int rows, int columns) {
        int[][] array = new int[rows][columns];
        for (int row = 0; row < rows; row++){
            for (int column = 0; column < columns; column++){
                int grade = (int)(Math.random()* (100 - 55 + 1) + 55);
                array[row][column] = grade;
            }
        }
        return array;
    }
    
    // print the students' grades
    public static void displayValues(int[][] arrays) {
        for (int rows = 0; rows < arrays.length; rows++) {
            System.out.println(Arrays.toString(arrays[rows]));
        }
    }
    
    // return average for one student
    public static double getAverage(int [] array){
        double sum = 0;
        for (int value: array) {
            sum += value;
        }

        return sum / (double) array.length; 
    }

    // return averages of every student
    public static double[] getAverages(int[][] arrays) {
        double[] averages = new double[arrays.length];
        for (int i = 0; i < arrays.length; i++) {
            averages[i] = getAverage(arrays[i]);
        }

        return averages;
    }

    // sort the array and return a new refrence of it
    public static double[] sort(double[] array) {
        double[] sorted = array.clone();
        Arrays.sort(sorted);
        return sorted;
    }
}