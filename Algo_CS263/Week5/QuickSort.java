package Algo_CS263.Week5;

import java.util.*;

class QuickSort {
    public static int partition(int[] array, int left, int right) {

        int partitionElement = array[left];
        int lower = left;
        for (int i = left + 1; i <= right; i++) {
            if (array[i] < partitionElement) {
                lower++;
                int temp = array[lower];
                array[lower] = array[i];
                array[i] = temp;
            }
        }
        int temp = array[lower];
        array[lower] = array[left];
        array[left] = temp;

        return lower;

    }

    public static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(array, left, right);
            quickSort(array, left, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, right);
        }
    }

    public static void main(String args[]) {
        int n = 2000;

        Random rand = new Random();
        long start, end, start1, end1;
        double timeElapsed;
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
            quickSort(a, 0, a.length - 1);
            end = System.nanoTime();
            totalTimeElapsedForSorted += (double) (end - start) / 1000;

            start = System.nanoTime();
            quickSort(b, 0, b.length - 1);
            end = System.nanoTime();
            totalTimeElapsedForSortedDecreasing += (double) (end - start) / 1000;

            start = System.nanoTime();
            quickSort(c, 0, c.length - 1);
            end = System.nanoTime();
            totalTimeElapsedForRandom += (double) (end - start) / 1000;
        }

        System.out.println("Quick Sort");

        System.out.println(""
                + totalTimeElapsedForSorted / 15
                + "\n"
                + totalTimeElapsedForSortedDecreasing / 15
                + "\n" + totalTimeElapsedForRandom / 15);
    }
}