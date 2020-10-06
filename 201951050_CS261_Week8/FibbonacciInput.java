//package week8oops;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class FibbonacciInput {

    public static void main(String args[]) {
        try {
            File myObj = new File(args[1]);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }

            FileOutputStream fos = new FileOutputStream(myObj);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            //bw.write("hello");
            int n = Integer.parseInt(args[0]);
            int a = 0, b = 1;
            int c = a + b;
            for (int i = 1; i < n; i++) {
                bw.write(c + "");
                //bw.write("hello");
                System.out.println(c);
                bw.newLine();
                a = b;
                b = c;
                c = a + b;
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
