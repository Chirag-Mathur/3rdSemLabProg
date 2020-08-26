package Algo_CS263.Week5;

//201951050
//Chirag Mathur
import java.util.*;

class HeapLab5 {

    int partition(int arr[], int low, int high) 
    { 
        int pivot = arr[high];  
        int i = (low-1); // index of smaller element 
        for (int j=low; j<high; j++) 
        { 
            // If current element is smaller than the pivot 
            if (arr[j] < pivot) 
            { 
                i++; 
  
                // swap arr[i] and arr[j] 
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
  
        // swap arr[i+1] and arr[high] (or pivot) 
        int temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 
  
        return i+1; 
    } 
  
  
    /* The main function that implements QuickSort() 
      arr[] --> Array to be sorted, 
      low  --> Starting index, 
      high  --> Ending index */
    void quickSort(int arr[], int low, int high) 
    { 
        if (low < high) 
        { 
            /* pi is partitioning index, arr[pi] is  
              now at right place */
            int pi = partition(arr, low, high); 
  
            // Recursively sort elements before 
            // partition and after partition 
            quickSort(arr, low, pi-1); 
            quickSort(arr, pi+1, high); 
        } 
    } 


    public void heapify(int arr[], int index, int length) {
        int smallEleInd = index;
        int left = (2 * index) + 1;
        int right = (2 * index) + 2;

        if (left < length && arr[smallEleInd] > arr[left]) {
            smallEleInd = left;
        }

        if (right < length && arr[smallEleInd] > arr[right]) {
            smallEleInd = right;
        }

        if (smallEleInd != index) {
            int c = arr[smallEleInd];
            arr[smallEleInd] = arr[index];
            arr[index] = c;
            heapify(arr, smallEleInd, length);
        }
    }

    public void makeHeap(int arr[], int length) {
        int firstNonLeafIndex = (length / 2) - 1;

        for (int i = firstNonLeafIndex; i >= 0; i--) {
            heapify(arr, i, length);
        }
    }



    public void deleteRoot(int arr[], int length) {
        int temp = arr[0];
        arr[0] = arr[length - 1];
        arr[length - 1] = temp;

        heapify(arr, 0, length - 1);

    }

    public void insertionSort(int arr[], int length) {

        for (int i = 1; i < length; i++) {
            int sortedEle = arr[i];
            int k = i - 1;

            while (k >= 0 && arr[k] > sortedEle) {
                arr[k + 1] = arr[k];
                k--;
            }
            arr[k + 1] = sortedEle;
        }

    }

    public void heapsort(int arr[], int length) {
        makeHeap(arr, length);

        for (int i = length - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, 0, i);
        }
    }

    public static void main(String args[]) {

        HeapLab5 obj = new HeapLab5();
        Random rand = new Random();
        int length = 10000;// Declaring size of the array
        int[] a1 = new int[length];
        int[] a2 = new int[length];
        int[] a3 = new int[length];

        int[] b1 = new int[length];
        int[] b2 = new int[length];
        int[] b3 = new int[length];

        int[] c1 = new int[length];
        int[] c2 = new int[length];
        int[] c3 = new int[length];

        // Generating a random array
        for (int i = 0; i < length; i++) {
            c1[i] = rand.nextInt(15000 + 1);

        }

        System.arraycopy(c1, 0, c2, 0, length - 1);
        c2[length - 1] = rand.nextInt(15000 + 1);
        System.arraycopy(c2, 0, c3, 0, length);
        System.arraycopy(c1, 0, a1, 0, length - 1);
        System.arraycopy(c2, 0, a2, 0, length);
        System.arraycopy(c3, 0, a3, 0, length);

        obj.insertionSort(a1, length - 1);

        obj.insertionSort(a2, length);
        obj.insertionSort(a3, length);

        for (int i = 0; i < length - 1; i++) {
            b1[length - i - 2] = a1[i];
        }

        for (int i = 0; i < length; i++) {
            b2[length - i - 1] = a2[i];
        }
        for (int i = 0; i < length; i++) {
            b3[length - i - 1] = a3[i];
        }

        
       

        double startTime;
        double endTime;
        double exeTimea1;
        double exeTimeb1;
        double exeTimec1;

        double exeTimea2;
        double exeTimeb2;
        double exeTimec2;

        double exeTimea3;
        double exeTimeb3;
        double exeTimec3;

        double n = 1000.0;

        //Quick Sort
        startTime = System.nanoTime();
        obj.quickSort(a3, 0, length-1);
        endTime = System.nanoTime();
        exeTimea2 = (endTime - startTime) / n;

        startTime = System.nanoTime();
        obj.quickSort(b3, 0, length-1);
        endTime = System.nanoTime();
        exeTimeb2 = (endTime - startTime) / n;

        startTime = System.nanoTime();
        obj.quickSort(c3, 0, length-1);
        endTime = System.nanoTime();
        exeTimec2 = (endTime - startTime) / n;

        //Heap Sort

        startTime = System.nanoTime();
        obj.heapsort(a3, length);
        endTime = System.nanoTime();
        exeTimea3 = (endTime - startTime) / n;

        startTime = System.nanoTime();
        obj.heapsort(b3, length);
        endTime = System.nanoTime();
        exeTimeb3 = (endTime - startTime) / n;

        startTime = System.nanoTime();
        obj.heapsort(c3, length);
        endTime = System.nanoTime();
        exeTimec3 = (endTime - startTime) / n;

        System.out.println("\n*****************************");

        System.out.println("Execution Time for Quick Sort in " + length);
        System.out.println(exeTimea2);
        System.out.println(exeTimeb2);
        System.out.println(exeTimec2);



        System.out.println("\n*****************************");

        System.out.println("Execution Time for Heap Sort in " + length);
        System.out.println(exeTimea3);
        System.out.println(exeTimeb3);
        System.out.println(exeTimec3);

    }

}