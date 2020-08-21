package Algo_CS263.Week3;

//201951050
//Chirag Mathur
import java.util.*;

class HeapLab4 {

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

    public void heapifyInsert(int arr[], int lastindex) {
        int parent = (lastindex - 1) / 2;
        while (arr[lastindex] < arr[parent]) {
            int temp = arr[lastindex];
            arr[lastindex] = arr[parent];
            arr[parent] = temp;

            lastindex = parent;
            parent = (lastindex - 1) / 2;
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

        HeapLab4 obj = new HeapLab4();
        Random rand = new Random();
        int length = 10000;//Declaring size of the array
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

        for (int i = 0; i < length - 1; i++)
         {
            b1[length - i - 2] = a1[i];
        }

        for (int i = 0; i < length; i++) {
            b2[length - i - 1] = a2[i];
        }
        for (int i = 0; i < length; i++) {
            b3[length - i - 1] = a3[i];
        }

        
        int item = rand.nextInt(15001);// genearate a random number for carrying out the insertion operation

        // we convert arrays to min heap for carrying out insertion and deletion
        // operation
        obj.makeHeap(a1, length - 1);
        obj.makeHeap(a2, length);
        obj.makeHeap(b1, length - 1);
        obj.makeHeap(b2, length);
        obj.makeHeap(c1, length - 1);
        obj.makeHeap(c2, length);

     

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
        startTime = System.nanoTime();
        a1[length - 1] = item;
        obj.heapifyInsert(a1, length - 1);
        endTime = System.nanoTime();
        exeTimea1 = (endTime - startTime) / n;

        startTime = System.nanoTime();
        b1[length - 1] = item;
        obj.heapifyInsert(b1, length - 1);
        endTime = System.nanoTime();
        exeTimeb1 = (endTime - startTime) / n;

        startTime = System.nanoTime();
        c1[length - 1] = item;
        obj.heapifyInsert(c1, length - 1);
        endTime = System.nanoTime();
        exeTimec1 = (endTime - startTime) / n;
        
        startTime = System.nanoTime();
        obj.deleteRoot(a2, length);
        endTime = System.nanoTime();
        exeTimea2 = (endTime - startTime) / n;

        startTime = System.nanoTime();
        obj.deleteRoot(b2, length);
        endTime = System.nanoTime();
        exeTimeb2 = (endTime - startTime) / n;

        startTime = System.nanoTime();
        obj.deleteRoot(c2, length);
        endTime = System.nanoTime();
        exeTimec2 = (endTime - startTime) / n;
        
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

        System.out.println("Execution Time for insertion in " + length);
        System.out.println(exeTimea1);
        System.out.println(exeTimeb1);
        System.out.println(exeTimec1);

        System.out.println("*****************************");
        System.out.println("Execution Time for deletion in " + length);
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