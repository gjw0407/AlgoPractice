package baekjoon.gold;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class G5_1038_감소하는수 {
    static List<Long> list;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        list = new ArrayList<>();

        if (N <= 10) {
            System.out.println(N);
        } else if (N > 1022) {
            System.out.println("-1");
        } else {
            for (int i = 0; i < 10; i++) {
                find(i, 1);
            }
            Collections.sort(list);

            System.out.println(list.get(N));
        }

    }

    public static void find(long num, int idx) {
        if (idx > 10) {
            return;
        }
        list.add(num);
        for (int i = 0; i < num % 10; i++) {
            find((num * 10) + i, idx + 1);
        }

    }

}
