package OOPs_CS261.Week1;

import java.util.Scanner;

//Chirag Mathur
//201951050
class LargestThree {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int a, b, c;

        System.out.println("Enter the 3 numbers");
        //taking inputs
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        //Checking Logic
        if (a >= b) {
            if (a >= c) {
                System.out.println(a);
            } else {
                System.out.println(c);
            }
        } else {
            if (b >= c) {
                System.out.println(b);
            } else {
                System.out.println(c);
            }

        }

        sc.close();

    }
}
