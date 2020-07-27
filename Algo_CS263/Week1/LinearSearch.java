package Algo_CS263.Week1;

import java.util.Scanner;

class LinearSearch {
    Scanner sc = new Scanner(System.in);

    int search(int key, int arr[], int l) {
        int val = -1;
        for (int i = 0; i < l; i++) {
            if (key == arr[i]) {
                return i;
            }
        }
        return val;
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
        int var;
        System.out.println("Enter the element to be searched");
        var = sc.nextInt();
        LinearSearch obj = new LinearSearch();
        int pos = obj.search(var, arr, n);
        if (pos == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at " + (pos + 1));
        }

        sc.close();

    }
}
