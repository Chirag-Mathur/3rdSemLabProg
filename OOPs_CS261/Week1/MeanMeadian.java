package OOPs_CS261.Week1;

import java.util.Scanner;

//Chirag Mathur
//201951050
class MeanMedian {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n;
        n = 5;
        int arr[] = new int[n];
        double sum = 0.0;
        System.out.println("Enter the elements in a stored manner");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();// taking input
            sum += arr[i];// adding all the elements
        }
        System.out.println("Mean = " + (sum / 5) + " Median = " + arr[2]);// printing output

        sc.close();

    }
}
