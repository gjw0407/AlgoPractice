package inflearn.array;

import java.util.Scanner;

public class 가위바위보 {
    public String solution(int n, int[] arr, int[] arr2) {
        String answer = "";

        if (arr[n] == arr2[n]) {
            answer = "D";
            return answer;
        } else if (arr[n] == 1 && arr2[n] == 3) {
            answer = "A";
            return answer;
        } else if (arr[n] == 2 && arr2[n] == 1) {
            answer = "A";
            return answer;
        } else if (arr[n] == 3 && arr2[n] == 2) {
            answer = "A";
            return answer;
        } else {
            answer = "B";
            return answer;
        }

    }

    public static void main(String[] args) {
        가위바위보 T = new 가위바위보();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int[] arr2 = new int[n];
        for (int i = 0; i < n; i++) {
            arr2[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            System.out.println(T.solution(i, arr, arr2));
        }
    }
}
