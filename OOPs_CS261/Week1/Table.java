package OOPs_CS261.Week1;

import java.util.Scanner;

//Chirag Mathur
//201951050
class Table {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int l;

        System.out.println("Enter the number");
        l = sc.nextInt();
        System.out.println("Table till 10 of the given number");
        for (int i = 1; i <= 10; i++) {
            System.out.println(l + " X " + i + " = " + (l * i));
        }

        sc.close();

    }
}
