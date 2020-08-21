package Algo_CS263.Week1;

import java.util.Scanner;

class SelectionSort {
    // Scanner sc = new Scanner(System.in);

    void sort(int a[], int n) {
        int var;
        int min_index;

        for (int i = 0; i < n; i++) {
            min_index = i;

            for (int j = i + 1; j < n; j++) {
                if (a[min_index] > a[j]) {
                    min_index = j;
                }
            }

            var = a[i];
            a[i] = a[min_index];
            a[min_index] = var;

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

        SelectionSort obj = new SelectionSort();
        obj.sort(arr, n);

        sc.close();

    }
}
