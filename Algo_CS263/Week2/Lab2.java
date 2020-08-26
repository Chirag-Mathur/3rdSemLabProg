package Algo_CS263.Week2;

//Chirag Mathur
//201951050
import java.util.*;

public class Lab2 {

    long bubbleSort(int arr[]) {
        // Copying the array
        // Bubble sort algorith will work on this array
        int a[] = new int[3001];
        for (int i = 0; i < 3001; ++i) {
            a[i] = arr[i];
        }

        // Starting time of the algo
        long start = System.nanoTime();
        int n = 3001 - 1;
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
        // Ending time of the algo
        long end = System.nanoTime();
        return ((end - start) / 1000);
    }

    long insertionSort(int arr[]) {
        // Copying the array
        // Insertion sort algorith will work on this array
        int a[] = new int[3001];
        for (int i = 0; i < 3001; ++i) {
            a[i] = arr[i];
        }

        // Starting time of the algo
        long start = System.nanoTime();
        int n = 3001;
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
        // Ending time of the algo
        long end = System.nanoTime();
        return ((end - start) / 1000);
    }

    long selectionSort(int arr[]) {
        // Copying the array
        // Selection sort algorith will work on this array
        int a[] = new int[3001];
        for (int i = 0; i < 3001; ++i) {
            a[i] = arr[i];
        }

        // Starting time of the algo
        long start = System.nanoTime();
        int n = 3001;
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
        // Ending time of the algo
        long end = System.nanoTime();
        return ((end - start) / 1000);
    }

    long linearSearch(int arr[], int k) {
        // Copying the array
        // Linear Search algorith will work on this array
        int a[] = new int[3001];
        for (int i = 0; i < 3001; ++i) {
            a[i] = arr[i];
        }

        // Starting time of the algo
        long start = System.nanoTime();
        int n = 3001;
        int i = 0;
        while (i < n && a[i] != k) {
            ++i;
        }
        // if (i == n) {
        // System.out.println(k + " not found");
        // } else {
        // System.out.println("Found at position: - " + i);
        // }

        // Ending time of the algo
        long end = System.nanoTime();
        return ((end - start) / 1000);
    }

    long binarySearch(int arr[], int k) {
        // As array are passed as refrance so we copy array passed as Argument and work
        // with the copy of the array
        int a[] = new int[3001];
        for (int i = 0; i < 3001; ++i) {
            a[i] = arr[i];
        }

        // Start noting the time
        long start = System.nanoTime();

        int n = 3001;
        int left = 0;
        int right = n - 1;
        int mid = (left + right) / 2;
        while (left <= right) {
            if (a[mid] == k) {
                break;
            } else if (a[mid] > k) {
                right = mid - 1;
                mid = (left + right) / 2;
            } else {
                left = mid + 1;
                mid = (left + right) / 2;
            }
        }

        // if (left <= right) {
        // System.out.println(k + " was found at position " + mid);
        // } else {
        // System.out.println(k + " not found");
        // }

        // Stop noting the time
        long end = System.nanoTime();
        return ((end - start));
    }

    public static void main(String args[]) {
        Random rand = new Random();
        int C[] = new int[3001];
        int B[] = new int[3001];
        int A[] = new int[3001];

        // Creating an array of random integers
        for (int i = 0; i < 3001; ++i) {
            C[i] = rand.nextInt(3001);
        }

        // Copy elements from array C to A
        for (int i = 0; i < 3001; ++i) {
            A[i] = C[i];
        }
        // sorted the array A in increasing order
        Arrays.sort(A);

        // sorted the array B in descending order
        for (int i = 0; i < 3001; ++i) {
            B[i] = A[3001 - (i + 1)];
        }

        Lab2 obj = new Lab2(); // Created the object of the class
        long sum = 0;
        System.out.println(
                "Execution time of Selection Sort Alorithm, it s best case, average case and worst case are respectively");
        sum = 0;
        for (int i = 0; i < 15; i++) {
            sum += obj.selectionSort(A);
        }
        System.out.println(sum / 15);
        sum = 0;
        for (int i = 0; i < 15; i++) {
            sum += obj.selectionSort(C);
        }
        System.out.println(sum / 15);
        sum = 0;
        for (int i = 0; i < 15; i++) {
            sum += obj.selectionSort(B);
        }
        System.out.println(sum / 15);

        System.out.println("----------------------------------------");
        System.out.println(
                "Execution time of Bubble Sort Alorithm, it s best case, average case and worst case are respectively");
        sum = 0;
        for (int i = 0; i < 15; i++) {
            sum += obj.bubbleSort(A);
        }
        System.out.println(sum / 15);
        sum = 0;
        for (int i = 0; i < 15; i++) {
            sum += obj.bubbleSort(C);
        }
        System.out.println(sum / 15);
        sum = 0;
        for (int i = 0; i < 15; i++) {
            sum += obj.bubbleSort(B);
        }
        System.out.println(sum / 15);

        System.out.println("----------------------------------------");
        System.out.println(
                "Execution time of Insertion Sort Alorithm, it s best case, average case and worst case are respectively");
        sum = 0;
        for (int i = 0; i < 15; i++) {
            sum += obj.insertionSort(A);
        }
        System.out.println(sum / 15);
        sum = 0;
        for (int i = 0; i < 15; i++) {
            sum += obj.insertionSort(C);
        }
        System.out.println(sum / 15);
        sum = 0;
        for (int i = 0; i < 15; i++) {
            sum += obj.insertionSort(B);
        }
        System.out.println(sum / 15);

        System.out.println("----------------------------------------");
        System.out.println(
                "Execution time of Linear Search Alorithm, it s best case, average case and worst case are respectively");
        sum = 0;
        for (int i = 0; i < 15; i++) {
            sum += obj.linearSearch(A, A[0]);
        }
        System.out.println(sum / 15);
        sum = 0;
        for (int i = 0; i < 15; i++) {
            sum += obj.linearSearch(A, A[1500]);
        }
        System.out.println(sum / 15);
        sum = 0;
        for (int i = 0; i < 15; i++) {
            sum += obj.linearSearch(A, A[3000]);
        }
        System.out.println(sum);

        System.out.println("----------------------------------------");
        System.out.println("Execution time of Binary Search Alorithm, it s best case, average case, worst case is");
        sum = 0;
        for (int i = 0; i < 15; i++) {
            sum += obj.binarySearch(A, A[1500]);
        }
        System.out.println(sum / 15);
        sum = 0;
        for (int i = 0; i < 15; i++) {
            sum += obj.binarySearch(A, A[750]);
            // }
            System.out.println(sum / 15);
            sum = 0;
            // for (int i = 0; i < 15; i++) {
            sum += obj.binarySearch(A, A[0]);
            // }
            System.out.println(sum / 15);

            // obj.binarySearch(A, 521);

            System.out.println("----------------------------------------");
        }
    }
}
