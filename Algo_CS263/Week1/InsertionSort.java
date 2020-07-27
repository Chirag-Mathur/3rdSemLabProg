package Algo_CS263.Week1;

import java.util.Scanner;

class InsertionSort {
    // Scanner sc = new Scanner(System.in);

    void sort(int a[], int n) {
        int var, j;
        for (int i = 1; i < n; i++) {
            var = a[i];
            j = i - 1;
            while (j >= 0 && a[j] > var) {
                a[j + 1] = a[j];
                j = j - 1;
            }
            a[j + 1] = var;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no. of elements to be stored");
        int n;
        n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the elements");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        InsertionSort obj = new InsertionSort();
        obj.sort(arr, n);

        sc.close();

    }
}
