package Algo_CS263.Week11;

import java.util.*;
import java.io.*;

public class Kruskal {
    class Edge implements Comparable<Edge> {
        int src, dest, weight;

        public int compareTo(Edge cmpEdge) {
            return this.weight - cmpEdge.weight;
        }
    };

    int V, E;
    Edge edge[];

    Kruskal(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[E];
        for (int i = 0; i < e; ++i)
            edge[i] = new Edge();
    }

    int find(int subsets[], int i) {

        if (subsets[i] != i)
            subsets[i] = find(subsets, subsets[i]);
        return subsets[i];
    }

    void KruskalMST() {
        Edge output[] = new Edge[V];
        int e = 0;

        int i = 0;
        for (i = 0; i < V; ++i)
            output[i] = new Edge();

        Arrays.sort(edge);
        int parent[] = new int[V];

        for (int v = 0; v < V; ++v)
            parent[v] = v;
        i = 0;

        while (e < V - 1) {

            Edge next_edge = new Edge();
            next_edge = edge[i++];
            int x = find(parent, next_edge.src);
            int y = find(parent, next_edge.dest);

            if (x != y) {
                output[e++] = next_edge;
                parent[x] = y;
            }

        }

        int minimumCost = 0;
        for (i = 0; i < e; ++i) {
            System.out.println(output[i].src + " -- " + output[i].dest + " => " + output[i].weight);
            minimumCost += output[i].weight;
        }
        System.out.println("Minimum Cost of the Spanning Tree is " + minimumCost);
    }

    // main method
    public static void main(String[] args) {
        int V, E;
        System.out.println("Enter the number of vertix and edge in the graph");
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        E = sc.nextInt();
        Kruskal graph = new Kruskal(V, E);

        System.out.println("Enter the source, dest and the weight of the each vertix");

        for (int i = 0; i < E; i++) {
            graph.edge[i].src = sc.nextInt();
            graph.edge[i].dest = sc.nextInt();
            graph.edge[i].weight = sc.nextInt();
        }
        long start = System.nanoTime();
        graph.KruskalMST();
        // calculating the time for radix sort
        long end = System.nanoTime();
        long microsec = (end - start) / 1000;
        System.out.println("Time for MST using kruskal's algo in micro seconds is " + microsec);

    }
}