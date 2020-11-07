package Algo_CS263.Week9;

import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Comparator;

class Huff_node {

    int data;
    char c;

    Huff_node left;
    Huff_node right;
}

class MyComparator implements Comparator<Huff_node> {
    public int compare(Huff_node x, Huff_node y) {
        return x.data - y.data;
    }
}

public class HuffmanCode {

    public static void printCode(Huff_node root, String s) {

        if (root.left == null && root.right == null && Character.isLetter(root.c)) {
            System.out.println(root.c + ":" + s);
            return;
        }
        printCode(root.left, s + "0");
        printCode(root.right, s + "1");
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = 6;
        char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' };
        int[] charfreq = { 5, 9, 12, 13, 16, 45 };
        PriorityQueue<Huff_node> q = new PriorityQueue<Huff_node>(n, new MyComparator());
        for (int i = 0; i < n; i++) {
            Huff_node hn = new Huff_node();
            hn.c = charArray[i];
            hn.data = charfreq[i];
            hn.left = null;
            hn.right = null;
            q.add(hn);
        }
        Huff_node root = null;
        while (q.size() > 1) {
            Huff_node x = q.peek();
            q.poll();
            Huff_node y = q.peek();
            q.poll();
            Huff_node f = new Huff_node();
            f.data = x.data + y.data;
            f.c = '-';
            f.left = x;
            f.right = y;
            root = f;
            q.add(f);
        }
        printCode(root, "");
    }
}