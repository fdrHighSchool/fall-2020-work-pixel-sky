import java.util.Scanner;

public class Agree {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("agree? ");
        String text = in.nextLine().toLowerCase();

        if (text.equals("yes")) {
            System.out.println("agree");
        }
        else {
            System.out.println("disagree");
        }

        in.close();
    }
}
