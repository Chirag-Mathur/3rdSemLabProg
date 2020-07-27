package Algo_CS263.Week1;

import java.util.Scanner;

class BinarySearch {
    Scanner sc = new Scanner(System.in);

    int search(int key, int arr[], int l) {
        int val = -1;
        int mid = l / 2;
        int first = 0;
        int last = l - 1;
        while (last >= first) {
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                first = mid + 1;
                mid = (first + last) / 2;

            } else {
                last = mid - 1;
                mid = (first + last) / 2;

            }
        }

        return val;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no. of elements to be stored in a sorted manner");
        int n;
        n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the elements");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int var;
        System.out.println("Enter the element to be searched ");
        var = sc.nextInt();
        BinarySearch obj = new BinarySearch();
        int pos = obj.search(var, arr, n);
        if (pos == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at " + (pos + 1));
        }

        sc.close();

    }
}
