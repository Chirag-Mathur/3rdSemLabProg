package Algo_CS263.Week9;

import java.util.*;

class DepthFirst {
    private int V; // No. of vertices

    private LinkedList<Integer> adj[];

    @SuppressWarnings("unchecked")
    DepthFirst(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    void edgeAdd(int v, int w) {
        adj[v].add(w);
    }

    void DFSTraverse(int v, boolean visited[]) {

        visited[v] = true;
        System.out.print(v + " ");

        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                DFSTraverse(n, visited);
        }
    }

    void DFS(int v) {

        boolean visited[] = new boolean[V];

        DFSTraverse(v, visited);
    }

    public static void main(String args[]) {
        DepthFirst g = new DepthFirst(6);

        g.edgeAdd(0, 1);
        g.edgeAdd(0, 2);
        g.edgeAdd(0, 5);
        g.edgeAdd(1, 2);
        g.edgeAdd(2, 0);
        g.edgeAdd(2, 3);
        g.edgeAdd(3, 3);
        g.edgeAdd(5, 3);
        g.edgeAdd(4, 5);

        System.out.println("Following is Depth First Traversal " + " from vertex 0");

        g.DFS(0);
    }
}
