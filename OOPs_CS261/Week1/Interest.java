package OOPs_CS261.Week1;

import java.util.Scanner;

//Chirag Mathur
//201951050
class Interest {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        Double pricipal, rate, time;

        double simpleInterest;
        System.out.println("Enter Principal Amount, Rate and time in years duration");
        pricipal = sc.nextDouble();
        rate = sc.nextDouble();
        time = sc.nextDouble();// taking input
        simpleInterest = pricipal * (1 + (rate * time));// Calculating Simple Interest

        System.out.println("Simple Interest = " + simpleInterest);// printing output

        sc.close();

    }
}
