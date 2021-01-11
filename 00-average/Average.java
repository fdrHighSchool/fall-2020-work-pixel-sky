import java.util.*;

public class Average {
  public static void main(String[] args) {
    //ask for 3 test grades
    final int COUNT = 3;
    Scanner input = new Scanner(System.in);
    int sum = 0;

    for (int i = 0; i < COUNT; i++) 
    {
        System.out.printf("Enter the score %d: ", i + 1);
        sum += input.nextInt();
    }
    input.close();
    System.out.printf("%.2f", sum / (float) COUNT);
  }
}
