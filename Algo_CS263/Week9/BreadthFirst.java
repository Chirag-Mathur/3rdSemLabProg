package Algo_CS263.Week9;

//Chirag Mathur
//201951050

import java.io.*;
import java.util.*;

class BreadhFirst {
    private int V;
    private LinkedList<Integer> adj[];

    BreadhFirst(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    void edgeAdd(int v, int w) {
        adj[v].add(w);
    }

    void BFS(int s) {

        boolean visit[] = new boolean[V];

        LinkedList<Integer> queue = new LinkedList<Integer>();

        visit[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            s = queue.poll();
            System.out.print(s + " ");

            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visit[n]) {
                    visit[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String args[]) {
        BreadhFirst g = new BreadhFirst(6);

        g.edgeAdd(0, 1);
        g.edgeAdd(0, 2);
        g.edgeAdd(0, 5);
        g.edgeAdd(1, 2);
        g.edgeAdd(2, 0);
        g.edgeAdd(2, 3);
        g.edgeAdd(3, 3);
        g.edgeAdd(5, 3);
        g.edgeAdd(4, 5);

        System.out.println("Following is the BFT " + " from vertex 0");

        g.BFS(0);
    }
}