public class NumberCube {
    public static void main(String[] args) {
        int[] tosses = getCubeTosses(new NumberCube(), 10);
        for (int num : tosses) {
            System.out.println(num);
        }
        System.out.println(getLongestRun(tosses));
    }

    /**
     * 
     * @return an integer value between 1 and 6. inclusive
     */
    public int toss() {
        return (int) Math.floor(Math.random() * 6) + 1;
    }

    /**
     * Return an array of values obtained by tossing a number cube numTosses times.
     * @param cube a NumberCube
     * @param numTosses the number of tosses to be recorded
     *          Precondition: numTosses > 0
     * @return an array of numTosses values
     */
    public static int[] getCubeTosses(NumberCube cube, int numTosses) {
        int[] tosses = new int[numTosses];

        for (int i = 0; i < numTosses; i++) {
            tosses[i] = cube.toss();
        }

        return tosses;
    } 

    /**
     * Returns the starting index of a longest run of two or more conseccutive repeated values
     * in the array values.
     * @param values an array of integer values representing a series of number cube tosses
     *          Precondition: values.length > 0
     * @return the starting index of a run of maximum size;
     *          -1 if there is no run
     */
    public static int getLongestRun(int[] values) {
        int index = 0;
        int highest = 0;
        int currentComp = 0;
        int count = 0;
        
        for (int currentIndex = 0; currentIndex < values.length; currentIndex++) {
            if (values[currentComp] == values[currentIndex]) {
                count++;
            }
            else {
                if (count > highest) {
                    highest = count;
                    index = currentComp;
                }
                currentComp = currentIndex;
                count = 1;
            }
        }

        if (highest < 2) {
            return -1;
        }
        else {
            return index;
        }
    }
}
