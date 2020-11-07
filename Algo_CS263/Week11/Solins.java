package Algo_CS263.Week11;

import Algo_CS263.Week11.*;
import java.util.*;

public class Solins {

    class Edge {
        int src, dest, weight;
    };

    int V, E;
    Edge edge[];

    Solins(int v, int e) {
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

    public void SollinMST() {
        int parent[] = new int[V];
        int cheapest[] = new int[V];

        for (int v = 0; v < V; ++v) {
            parent[v] = v;
            cheapest[v] = -1;
        }

        int numTrees = V;
        int MSTweight = 0;

        while (numTrees > 1) {

            for (int v = 0; v < V; ++v)
                cheapest[v] = -1;

            for (int i = 0; i < E; i++) {

                int set1 = find(parent, edge[i].src);
                int set2 = find(parent, edge[i].dest);

                if (set1 == set2)
                    continue;

                else {
                    if (cheapest[set1] == -1 || edge[cheapest[set1]].weight > edge[i].weight)
                        cheapest[set1] = i;

                    if (cheapest[set2] == -1 || edge[cheapest[set2]].weight > edge[i].weight)
                        cheapest[set2] = i;
                }
            }

            for (int i = 0; i < V; i++) {

                if (cheapest[i] != -1) {
                    int set1 = find(parent, edge[cheapest[i]].src);
                    int set2 = find(parent, edge[cheapest[i]].dest);

                    if (set1 == set2)
                        continue;
                    MSTweight += edge[cheapest[i]].weight;
                    System.out.println(edge[cheapest[i]].src + " --" + edge[cheapest[i]].dest + " =>6 "
                            + edge[cheapest[i]].weight);

                    parent[set1] = set2;
                    numTrees--;
                }
            }
        }

        System.out.println("Weight of MST is " + MSTweight);
        return;
    }

    public static void main(String[] args) {
        int V, E;
        System.out.println("Enter the number of vertix and edge in the graph");
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        E = sc.nextInt();
        Solins graph = new Solins(V, E);

        System.out.println("Enter the sorce, destination and the  weight of the each vertix");

        for (int i = 0; i < E; i++) {
            graph.edge[i].src = sc.nextInt();
            graph.edge[i].dest = sc.nextInt();
            graph.edge[i].weight = sc.nextInt();
        }
        long start = System.nanoTime();
        graph.SollinMST();

        long end = System.nanoTime();
        long microseconds = (end - start) / 1000;
        System.out.println("Time for MST using Prim's algo in micro seconds is " + microseconds);

    }
}
