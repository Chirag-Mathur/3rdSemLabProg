package Algo_CS263.Week11;

public class Prims {
    int minValue(int key[], Boolean mstSet[], int v) {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index = -1;
        for (int i = 0; i < v; i++)
            if (mstSet[i] == false && key[i] < min) {
                min = key[i];
                min_index = i;
            }
        return min_index;
    }

    void printMST(int parent[], int graph[][]) {
        int min_weight = 0;
        for (int i = 1; i < parent.length; i++) {
            System.out.println(parent[i] + " - " + i + " => " + graph[i][parent[i]]);
            min_weight += graph[i][parent[i]];
        }
        System.out.println("Total weight of minimum spanning tree is " + min_weight);
    }

    void prims_method(int graph[][], int n) {

        int parent[] = new int[n];

        int key[] = new int[n];

        Boolean mstSet[] = new Boolean[n];

        for (int i = 0; i < n; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        key[0] = 0;

        parent[0] = -1;

        for (int count = 0; count < n - 1; count++) {

            int u = minValue(key, mstSet, n);

            mstSet[u] = true;

            for (int v = 0; v < n; v++)

                if (graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
        }

        printMST(parent, graph);
    }

    public static void main(String[] args) {
        Prims p = new Prims();
        int v = 5;
        int graph[][] = new int[][] { { 0, 2, 0, 6, 0 }, { 2, 0, 3, 8, 5 }, { 0, 3, 0, 0, 7 }, { 6, 8, 0, 0, 9 },
                { 0, 5, 7, 9, 0 } };

        long start = System.nanoTime();
        p.prims_method(graph, v);

        long end = System.nanoTime();
        long microseconds = (end - start) / 1000;
        System.out.println("Time for MST using Prim's algo in micro seconds is " + microseconds);
    }
}
