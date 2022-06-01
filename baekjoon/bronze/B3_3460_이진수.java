package baekjoon.bronze;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B3_3460_이진수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int n = sc.nextInt();

            StringBuilder sb = new StringBuilder();

            while (true) {
                if (n == 1) {
                    sb.append(1);
                    break;
                }
                sb.append(n % 2);
                n = n / 2;

            }

            String s = String.valueOf(sb);
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    list.add(i);
                }
            }

            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
        }
    }

    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int max = -1000001;
        int min = 1000001;
        for (int t = 0; t < T; t++) {
            int n = sc.nextInt();

            if (n > max) {
                max = n;
            }

            if (n < min) {
                min = n;
            }

        }
        System.out.print(min + " " + max);

    }
}
