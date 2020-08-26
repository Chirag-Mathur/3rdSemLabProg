package Algo_CS263.Week5;

import java.util.*;

class MergeSort {

    public static void merge(int[] array, int left, int mid, int right) {
        int a[] = new int[(mid - left) + 1];
        int b[] = new int[(right - mid)];

        for (int i = 0; i < a.length; i++) {
            a[i] = array[left + i];
        }

        for (int i = 0; i < b.length; i++) {
            b[i] = array[mid + 1 + i];
        }

        int lower = 0, upper = 0, i = left;
        while (lower < a.length && upper < b.length) {
            if (a[lower] <= b[upper]) {
                array[i] = a[lower];
                lower++;
            } else {
                array[i] = b[upper];
                upper++;
            }
            i++;
        }
        while (lower < a.length) {
            array[i] = a[lower];
            i++;
            lower++;
        }
        while (upper < b.length) {
            array[i] = b[upper];
            i++;
            upper++;
        }
    }

    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            // System.out.println((left+right)/2+" "+mid);
            // System.exit(0);
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    public static void main(String args[]) {
        int n = 2000;
        // System.out.println("Enter no. of elements in the array");
        Random rand = new Random();
        long start, end;
        double totalTimeElapsedForRandom = 0, totalTimeElapsedForSorted = 0, totalTimeElapsedForSortedDecreasing = 0;
        for (int k = 0; k < 15; k++) {
            int c[] = new int[n];

            for (int i = 0; i < n; i++) {
                c[i] = rand.nextInt(n);
            }
            int a[] = c.clone();
            int b[] = c.clone();
            Arrays.sort(a);
            for (int i = 0; i < n; i++) {
                b[n - i - 1] = a[i];
            }
            // int arr[]=new int[]{3,8,6,7,5,2};
            start = System.nanoTime();
            mergeSort(a, 0, a.length - 1);
            end = System.nanoTime();
            totalTimeElapsedForSorted += (double) (end - start) / 1000;

            start = System.nanoTime();
            mergeSort(b, 0, b.length - 1);
            end = System.nanoTime();
            totalTimeElapsedForSortedDecreasing += (double) (end - start) / 1000;

            start = System.nanoTime();
            mergeSort(c, 0, c.length - 1);
            end = System.nanoTime();
            totalTimeElapsedForRandom += (double) (end - start) / 1000;
        }
        System.out.println("Merge Sort");

        System.out.println(""
                + totalTimeElapsedForSorted / 15
                + "\n"
                + totalTimeElapsedForSortedDecreasing / 15
                + "\n" + totalTimeElapsedForRandom / 15);
        // for(int i=0;i<arr.length;i++){
        // System.out.print(arr[i]+" ");
        // }

    }

}