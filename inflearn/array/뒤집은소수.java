package inflearn.array;

import java.util.Scanner;

public class 뒤집은소수 {
    public boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }

        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public String solution(int n, int[] arr) {
        String answer = "";

        for (int i = 0; i < n; i++) {
            String temp = new StringBuilder(String.valueOf(arr[i])).reverse().toString();
            int reverseNum = Integer.parseInt(temp);
            if (isPrime(reverseNum)) {
                answer += (String.valueOf(reverseNum) + " ");
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        뒤집은소수 T = new 뒤집은소수();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(T.solution(n, arr));
    }
}
