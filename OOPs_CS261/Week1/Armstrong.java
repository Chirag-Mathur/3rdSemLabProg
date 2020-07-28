package OOPs_CS261.Week1;

import java.util.Scanner;

//Chirag Mathur
//201951050
class Armstrong {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int l;
        int number;

        System.out.println("Enter the number");
        l = sc.nextInt();// taking input
        number = l;
        int sum = 0;
        while (l > 0) {
            sum += (l % 10) * (l % 10) * (l % 10);// applying logic
            //System.out.println(sum+" ");
            l = l / 10;
        }
        //printing output
        if (sum == number) {
            System.out.println("Armstrong Number");

        }else{
            System.out.println("Not a Armstrong Number");
        }

        sc.close();

    }
}
