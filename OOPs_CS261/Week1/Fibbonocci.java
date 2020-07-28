package OOPs_CS261.Week1;

import java.util.Scanner;

//Chirag Mathur
//201951050
class Fibbonocci {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int l;

        System.out.println("Enter the number");
        l = sc.nextInt();
        int a = 0, b = 1;
        int c;
        if (l == 1) {
            System.out.println(a);//base condition

        } else if (l == 2) {
            System.out.println(a + " " + b);//base condition

        } else {
            System.out.print(a + " " + b+" ");
            for (int i = 3; i <= l; i++) {

                c = a + b;//adding two previous numbers
                System.out.print(c + " ");
                //storing last two numbers
                a = b;
                b = c;
            }
            System.out.println();
        }

        sc.close();

    }
}
