package OOPs_CS261.Week1;

import java.util.Scanner;

//Chirag Mathur
//201951050
class Factorial {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int l;

        System.out.println("Enter the number");
        l = sc.nextInt();//taking input
        int product = 1;
        if (l == 0) {
            System.out.println(1);

        } else {
            while (l > 0) {
                // calculating factorial
                product *= l;
                l--;

            }
        }
        System.out.println("Factorial =" + product);//printing output

        sc.close();

    }
}
