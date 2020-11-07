package Algo_CS263.Week8;

import java.util.*;

public class MatrixMul {
    int matOrder(int array[], int n) {
        int mini_mult[][] = new int[n][n];
        for (int i = 1; i < n; i++)
            mini_mult[i][i] = 0;
        for (int len = 2; len < n; len++) {
            for (int i = 1; i < n - len + 1; i++) {
                int j = i + len - 1;
                mini_mult[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    int q = mini_mult[i][k] + mini_mult[k + 1][j] + array[i] * array[k] * array[j];
                    if (q < mini_mult[i][j])
                        mini_mult[i][j] = q;
                }
            }
        }
        return mini_mult[1][n - 1];
    }

    public static void main(String args[]) {
        int n;
        System.out.println("Enter size");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int p[] = new int[n];
        System.out.println("Enter elements");
        for (int i = 0; i < n; i++) {
            p[i] = sc.nextInt();
        }
        MatrixMul obj = new MatrixMul();
        System.out.println("No. of matrix mul:" + obj.matOrder(p, n));
    }
}