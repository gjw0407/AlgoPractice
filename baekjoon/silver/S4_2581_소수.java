package baekjoon.silver;

import java.util.ArrayList;
import java.util.Scanner;

public class S4_2581_소수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int M = sc.nextInt();
        int N = sc.nextInt();

        for (int i = M; i <= N; i++) {
            int cnt = 0;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    break;
                } else {
                    cnt++;
                }
            }
            if (cnt == i - 2) {
                list.add(i);
            }
        }

        if (list.size() == 0) {
            System.out.println(-1);
        } else {
            int total = 0;
            for (int i = 0; i < list.size(); i++) {
                total += list.get(i);
            }
            System.out.println(total);
            System.out.println(list.get(0));
        }

    }
}
