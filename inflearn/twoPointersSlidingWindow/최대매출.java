package inflearn.twoPointersSlidingWindow;

import java.util.Scanner;

public class 최대매출 {
    public int solution(int n, int m, int[] arr) {
        int answer = 0, sum = 0;

        for (int i = 0; i < m; i++) {
            sum += arr[i];
        }
        answer = sum;

        for (int i = m; i < n; i++) {
            sum += (arr[i] - arr[i - m]);
            answer = Math.max(answer, sum);
        }

        return answer;
    }

    public static void main(String[] args) {
        최대매출 T = new 최대매출();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.print(T.solution(n, m, arr));
    }
}
