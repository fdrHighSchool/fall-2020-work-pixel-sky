import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner datas = new Scanner(new File("data.txt"));

            while (datas.hasNext()) {
                String data1 = datas.next();
                String complement1 = Integer.toString(2020 - Integer.parseInt(data1));
                Scanner temp1 = new Scanner(new File("data.txt"));
            
                while (temp1.hasNext()) {
                    String data2 = temp1.next();
                    String complement2 = Integer.toString(Integer.parseInt(complement1) - Integer.parseInt(data2));
                    Scanner temp2 = new Scanner(new File("data.txt"));

                    if (!(Integer.parseInt(complement2) < 0)) {
                        while (temp2.hasNext()) {
                            if (temp2.next().equals(complement2)) {
                                System.out.printf("%s, %s, %s\n", data1, data2, complement2);
                                System.out.println(Integer.parseInt(data1) * Integer.parseInt(data2) * Integer.parseInt(complement2));
                                temp1.close();
                                temp2.close();
                                datas.close();
                                System.exit(0);
                            }
                        }
                    }
                }
            }
        }
        catch (FileNotFoundException | NullPointerException e) {
            System.out.println("ERROR: can't open file");
        }
    }
}