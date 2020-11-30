import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("direction: ");
        String direction = in.nextLine();
        int floor = 0;
        for (int i = 0; i < direction.length(); i++) {
            if (direction.charAt(i) == '(') {floor++;}
            else {floor--;}
        }
        System.out.println(floor);
        in.close();
    }
}