package OOPs_CS261.Week1;

import java.util.Scanner;

//Chirag Mathur
//201951050
class SumOfDigits {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int l;

        System.out.println("Enter the number");
        l = sc.nextInt();// taking input

        int sum = 0;
        while (l > 0) {
            sum += (l % 10);//applying logic
            l = l / 10;
        }
        System.out.println("Sum of Digits = " + sum);

        sc.close();

    }
}
