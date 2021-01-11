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
                
                int min = Integer.parseInt(buffer.substring(0, buffer.indexOf("-")));
                int max = Integer.parseInt(buffer.substring(buffer.indexOf("-") + 1, colonIndex - 2));

                int count = 0;
                char letter = buffer.charAt(colonIndex - 1);
                String password = buffer.substring(colonIndex + 2);
                for (int i = 0; i < password.length(); i++) {
                    if (password.charAt(i) == letter) {
                        count++;
                    }
                }
                
                if (min <= count && count <= max) 
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
