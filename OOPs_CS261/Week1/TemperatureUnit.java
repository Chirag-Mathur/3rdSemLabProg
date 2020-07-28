package OOPs_CS261.Week1;

import java.util.Scanner;

//Chirag Mathur
//201951050
class TemperatureUnit {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        double farenheight;

        System.out.println("Enter the temperature in farenheight");
        farenheight = sc.nextDouble();// taking input
        double celcius = (farenheight - 32) * 0.55;// formula for changing farenheight into celcius
        System.out.println("Temperature in Celcius = " + celcius);

        sc.close();

    }
}
