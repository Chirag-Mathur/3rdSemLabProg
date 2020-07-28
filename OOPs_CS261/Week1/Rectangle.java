package OOPs_CS261.Week1;

import java.util.Scanner;

//Chirag Mathur
//201951050
class Rectangle {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int l, b;

        double area = 0.0;
        System.out.println("Enter the 2 sides of a rectangle");
        l = sc.nextInt();
        b = sc.nextInt();//taking input
        area = l * b;// Calculating Area

        System.out.println("Area = " + area);// printing output

        sc.close();

    }
}
