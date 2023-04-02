package inflearn.twoPointersSlidingWindow;

import java.util.ArrayList;
import java.util.Scanner;

public class 두배열합치기 {
    public ArrayList<Integer> solution(int n, int m, int[] arr, int[] arr2) {
        ArrayList<Integer> answer = new ArrayList<>();
        int p1 = 0, p2 = 0;
        while (p1 < n && p2 < m) {
            if (arr[p1] < arr2[p2]) {
                answer.add(arr[p1++]);
            } else {
                answer.add(arr2[p2++]);
            }
        }

        while (p1 < n) {
            answer.add(arr[p1++]);
        }
        while (p2 < m) {
            answer.add(arr2[p2++]);
        }

        return answer;
    }

    public static void main(String[] args) {
        두배열합치기 T = new 두배열합치기();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int m = in.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++) {
            arr2[i] = in.nextInt();
        }
        for (int x : T.solution(n, m, arr, arr2)) {
            System.out.print(x + " ");
        }
    }
}
