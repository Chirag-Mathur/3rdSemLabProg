package Algo_CS263.Week1;

import java.util.Scanner;

class BubbleSort {
    // Scanner sc = new Scanner(System.in);

    void sort(int a[], int n) {
        int var;
        int flag = 0;

        for (int i = 0; i < n - 1; i++) {
            flag = 0;
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    var = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = var;
                    flag = 1;
                }
            }
            if (flag == 0) {
                break;
            }
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

        BubbleSort obj = new BubbleSort();
        obj.sort(arr, n);

        sc.close();

    }
}
