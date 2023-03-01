package inflearn.array;

import java.util.Scanner;

public class 봉우리 {
    public boolean checkAround(int[][] arr, int r, int c) {
        if (arr[r][c] <= arr[r + 1][c] || arr[r][c] <= arr[r][c + 1] || arr[r][c] <= arr[r - 1][c] || arr[r][c] <= arr[r][c - 1]) {
            return false;
        }

        return true;
    }

    public int solution(int n, int[][] arr) {
        int max = 0;

        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= n; c++) {
                if (checkAround(arr, r, c)) {
                    max++;
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        봉우리 T = new 봉우리();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] arr = new int[n + 2][n + 2];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        System.out.print(T.solution(n, arr));
    }
}
