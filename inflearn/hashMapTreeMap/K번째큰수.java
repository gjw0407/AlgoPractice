package inflearn.hashMapTreeMap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

public class K번째큰수 {
    public int solution(int n, int k, int[] arr) {
        int answer = -1;

        TreeSet<Integer> map = new TreeSet<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int l = j + 1; l < n; l++) {
                    map.add(arr[i] + arr[j] + arr[l]);
                }
            }
        }

        int cnt = 0;
        for (int x : map) {
            cnt++;
            if (cnt == k) {
                return x;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        K번째큰수 T = new K번째큰수();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.print(T.solution(n, k, arr));
    }
}
