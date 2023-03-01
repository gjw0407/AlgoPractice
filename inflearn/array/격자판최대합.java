package inflearn.array;

import java.util.Scanner;

public class 격자판최대합 {
    public int solution(int n, int[][] arr) {
        int max = 0;

        int diag = 0;
        int diag2 = 0;
        for (int r = 0; r < n; r++) {
            int temp = 0;
            int temp2 = 0;
            for (int c = 0; c < n; c++) {
                temp += arr[r][c];
                temp2 += arr[c][r];
                if (r == c) {
                    diag += arr[r][c];
                }
                if (r + c == n) {
                    diag2 += arr[r][c];
                }
            }

            if (max < temp) {
                max = temp;
            }
            if (max < temp2) {
                max = temp2;
            }
        }

        if (max < diag) {
            max = diag;
        }
        if (max < diag2) {
            max = diag2;
        }

        return max;
    }

    public static void main(String[] args) {
        격자판최대합 T = new 격자판최대합();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        System.out.print(T.solution(n, arr));
    }
}
