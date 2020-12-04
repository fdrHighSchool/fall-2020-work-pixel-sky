import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        try {
            int vaild = 0;
            Scanner data = new Scanner(new File("data.txt"));
            while (data.hasNextLine()) {
                String buffer = data.nextLine();
                int colonIndex = buffer.indexOf(":");
                
                int pos1 = Integer.parseInt(buffer.substring(0, buffer.indexOf("-")));
                int pos2 = Integer.parseInt(buffer.substring(buffer.indexOf("-") + 1, colonIndex - 2));

                char letter = buffer.charAt(colonIndex - 1);
                String password = buffer.substring(colonIndex + 2);
                if ((password.charAt(pos1 - 1) == letter) == (password.charAt(pos2 - 1) == letter) == false)
                    vaild++;
            }
            System.out.println(vaild);
            data.close();
        }
        catch (FileNotFoundException | NullPointerException e) {
            System.out.println("ERROR: can't open file");
        }
    }
}
