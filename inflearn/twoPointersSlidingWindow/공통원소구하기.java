package inflearn.twoPointersSlidingWindow;

import java.util.*;

public class 공통원소구하기 {
    public ArrayList<Integer> solution(int n, int m, int[] arr, int[] arr2) {
        ArrayList<Integer> answer = new ArrayList<>();

        Arrays.sort(arr);
        Arrays.sort(arr2);
        int p1 = 0, p2 = 0;
        while (p1 < n && p2 < m) {
            if (arr[p1] == arr2[p2]) {
                answer.add(arr[p1++]);
                p2++;
            } else if (arr[p1] < arr2[p2]) {
                p1++;
            } else {
                p2++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        공통원소구하기 T = new 공통원소구하기();
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
