package Algo_CS263.Week6;

import java.util.*;

public class SortingWeek6 {
    static void countSortt(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        int range = max - min + 1;
        int count[] = new int[range];
        int output[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] - min]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = output[i];
        }
    }

    ///////////////////////////////////////
    static void bucketSort(int arr[], int n) {
        if (n <= 0)
            return;

        // 1) Create n empty buckets
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] b = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            b[i] = new ArrayList<Integer>();
        }

        // 2) Put array elements in different buckets
        for (int i = 0; i < n; i++) {
            int idx = (int) arr[i] / n;
            b[idx].add(arr[i]);
        }

        // 3) Sort individual buckets
        for (int i = 0; i < n; i++) {
            Collections.sort(b[i]);
        }

        // 4) Concatenate all buckets into arr[]
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < b[i].size(); j++) {
                arr[index++] = b[i].get(j);
            }
        }
    }

    ////////////////////////////////////////
    static int getMax(int arr[], int n) {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }

    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    static void countSort(int arr[], int n, int exp) {
        int output[] = new int[n]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);

        // Store count of occurrences in count[]
        for (i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Build the output array
        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to curent digit
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }

    // The main function to that sorts arr[] of size n using
    // Radix Sort
    static void radixsort(int arr[], int n) {
        // Find the maximum number to know number of digits
        int m = getMax(arr, n);

        // Do counting sort for every digit. Note that instead
        // of passing digit number, exp is passed. exp is 10^i
        // where i is current digit number
        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }

    // A utility function to print an array
    static void print(int arr[], int n) {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }

    public static void main(String args[]) {
        Random rand = new Random();
        int length = 10000;// Declaring size of the array
        double startTime;
        double endTime;
        double exa, exb, exc;
        double n = 1000.0;

        int[] c1 = new int[length];
        int[] c2 = new int[length];
        int[] c3 = new int[length];

        for (int i = 0; i < length; i++) {
            c1[i] = rand.nextInt(15000 + 1);
            c2[i] = c1[i];
            c3[i] = c2[i];

        }

        startTime = System.nanoTime();
        countSortt(c1);
        endTime = System.nanoTime();
        exa = (endTime - startTime) / n;
        /////////////////////
        startTime = System.nanoTime();
        bucketSort(c2, length);
        endTime = System.nanoTime();
        exb = (endTime - startTime) / n;
        ///////////////////////
        startTime = System.nanoTime();
        radixsort(c3, length);
        endTime = System.nanoTime();
        exc = (endTime - startTime) / n;

        System.out.println("The time for count sort is: " + exa);
        System.out.println("The time for count sort is: " + exb);
        System.out.println("The time for count sort is: " + exc);

    }

}