package OOPs_CS261.Week1;

import java.util.Scanner;

//Chirag Mathur
//201951050
class LeapYear {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int l;

        System.out.println("Enter a year to check for a leap year");
        l = sc.nextInt();// taking input
        if (l % 100 == 0 && l % 400 == 0 || l % 100 != 0 && l % 4 == 0) // Applying logic
        {
            System.out.println("It is a leap year");// printing output

        } else {
            System.out.println("It is not a leap year");// printing output

        }

        sc.close();

    }
}
