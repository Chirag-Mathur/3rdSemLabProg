package Algo_CS263;
// Chirag Mathur
// 201951050
import java.util.*;

public class WorkLoad {

    static class work {

        int start;
        int finish;

        public work() {
            start = 0;
            finish = 0;
        }

        public work(int s, int f) {
            start = s;
            finish = f;
        }
    }

    int partition(work arr[], int low, int high) {
        int iofPar = arr[high].finish;
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (arr[j].finish < iofPar) {
                i++;

                work temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        work temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    void sortquick(work arr[], int low, int high) {
        if (low < high) {

            int parIN = partition(arr, low, high);

            sortquick(arr, low, parIN - 1);
            sortquick(arr, parIN + 1, high);
        }
    }

    void selectwork(work arr[], int n) {
        System.out.print("Activities are selected (Starting from #1) printed along staring time and ending time.");
        int j = 0;
        System.out.print("\n");
        System.out.print("#" + 1 + "(" + arr[0].start + "," + arr[0].finish + ")" + "\n");
        for (int i = 1; i < n; i++) {
            if (arr[i].start >= arr[j].finish) {
                System.out.println("#" + (i + 1) + "(" + arr[i].start + "," + arr[i].finish + ")" + "\t");
                j = i;
            }
        }
    }

    public static void main(String args[]) {
        WorkLoad obj = new WorkLoad();

        Random rand = new Random();
        int n = 80;
        work[] Array = new work[80];

        for (int i = 0; i < n; i++) {
            int a = rand.nextInt(95) + 1;
            Array[i] = new work(a, a + rand.nextInt(5) + 1);
        }

        obj.sortquick(Array, 0, n - 1);

        obj.selectwork(Array, n);

    }

}