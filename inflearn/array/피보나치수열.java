package inflearn.array;

import java.util.Scanner;

public class 피보나치수열 {
    public String solution(int n) {
        String answer = "";
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 1;

        for (int i = 2; i < n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        for (int i = 0; i < n; i++) {
            answer += (String.valueOf(arr[i]) + " ");
        }

        return answer;

    }

    public static void main(String[] args) {
        피보나치수열 T = new 피보나치수열();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(T.solution(n));
    }
}
