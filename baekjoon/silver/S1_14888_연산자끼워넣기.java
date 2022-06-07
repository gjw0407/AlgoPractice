package baekjoon.silver;

import java.util.Scanner;

public class S1_14888_연산자끼워넣기 {
    static int max = -1000000000;
    static int min = 1000000000;
    static int[] arr;
    static int[] op = new int[4];
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < 4; i++) {
            op[i] = sc.nextInt();
        }

        calc(arr[0], 1);

        System.out.println(max);
        System.out.println(min);
    }

    public static void calc(int num, int idx) {
        if (idx == N) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (op[i] > 0) {
                op[i]--;

                switch (i) {
                    case 0:
                        calc(num + arr[idx], idx + 1);
                        break;
                    case 1:
                        calc(num - arr[idx], idx + 1);
                        break;
                    case 2:
                        calc(num * arr[idx], idx + 1);
                        break;
                    case 3:
                        calc(num / arr[idx], idx + 1);
                        break;
                }

                op[i]++;
            }
        }
    }
}
