import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner datas = new Scanner(new File("data.txt"));

            while (datas.hasNext()) {
                String data = datas.next();
                String complement = Integer.toString(2020 - Integer.parseInt(data));
                Scanner temp = new Scanner(new File("data.txt"));
            
                while (temp.hasNext()) {
                    if (temp.next().equals(complement)) {
                        System.out.println(Integer.parseInt(data) * Integer.parseInt(complement));
                        temp.close();
                        datas.close();
                        System.exit(0);
                    }
                }
            }
        }
        catch (FileNotFoundException | NullPointerException e) {
            System.out.println("ERROR: can't open file");
        }
    }
}