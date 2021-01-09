import java.util.Arrays;

public class Student {
    // instance variables
    private String name;
    private String osis;
    private int[] grades;
  
    //------------------------------------------------//
  
    // constructor
    public Student(String name, String osis) {
        this.name = name;
        this.osis = osis;
        grades = new int[10];
    }//end constructor method
  
    //------------------------------------------------//
  
    // other methods
    public String getName() {
        return this.name;
    }//end getName method
  
  
    public String getOSIS() {
        return this.osis;
    }//end getOSIS method

    
    public int[] getGrades() {
        return this.grades;
    }
  
  
    public void setName(String name) {
        this.name = name;
    }//end setName method
  
    /*
     * N: addGrade
     * P: take-in a single grade and add it to the student's gradebook.
          should find the first non-zero index in the array and insert the grade
          there. if there is no room for that value, replace the lowest grade in 
          array with it.
     * I: grade (int)
     * R: n/a
     */
    public void addGrade(int grade) {
        boolean stillSearching = true;

        int indexOfLowestGrade = 0;
        int index = 0;

        while (index < this.grades.length && stillSearching) {
            if (this.grades[index] == 0) {
                indexOfLowestGrade = index;
                stillSearching = false;
            } 
            else if (this.grades[index] < this.grades[indexOfLowestGrade]) {
                indexOfLowestGrade = index;
            }

            index++;
        }

        this.grades[indexOfLowestGrade] = grade;
    }//end addGrade method
  
  
    public double calculateAverage() {
  
        return 0.0;
    }//end calculateAverage() method
  

    /*
     * Returns the String representation of a Student.
     * Right now, we are choosing to display the student's name and OSIS.
     * NOTE: This method overrides the default toString method that
     *       displays the memory address.
     */
    @Override
    public String toString() {
        return String.format("Student: %s\nOSIS: %s\nGrades: %s", this.name, this.osis, Arrays.toString(this.grades));
    }//end toString method
}//end class
