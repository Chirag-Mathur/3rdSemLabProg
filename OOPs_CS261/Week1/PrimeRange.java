package OOPs_CS261.Week1;

import java.util.Scanner;

//Chirag Mathur
//201951050
class PrimeRange {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int l, r;

        System.out.println("Enter the lower and upper range");
        l = sc.nextInt();// taking input
        r = sc.nextInt();// taking input

        for (int j = l; j <= r; j++) {
            int flag = 0;
            for (int i = 2; i < j; i++) {
                if (j % i == 0) {
                    flag = 1;
                    break;
                }

            }
            if (flag == 0) {
                System.out.print(j + " ");// printing output

            }

        }
        System.out.println();
        sc.close();

    }
}
