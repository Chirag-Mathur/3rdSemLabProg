package OOPs_CS261.Week1;

import java.util.Scanner;

//Chirag Mathur
//201951050
class Circle {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int radius;

        double area = 0.0, circumference = 0.0;
        System.out.println("Enter the radius of the circle");
        radius = sc.nextInt();
        area = Math.PI * radius * radius;// Calculating Area
        circumference = 2 * Math.PI * radius;// Calculating Circumference
        System.out.println("Area = " + area + " Circumference = " + circumference);// printing output

        sc.close();

    }
}
