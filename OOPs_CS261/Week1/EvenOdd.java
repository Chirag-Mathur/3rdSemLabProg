package OOPs_CS261.Week1;

import java.util.Scanner;

//Chirag Mathur
//201951050
class EvenOdd {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int l;

        System.out.println("Enter the number");
        l = sc.nextInt();
        if (l % 2 == 0) // Checking if it is even or odd
            {
                System.out.println("Even");

            } 
        else 
            {
                System.out.println("Odd");
            }

        sc.close();

    }
}
