package baekjoon.bronze;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B3_2501_약수구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                list.add(i);
            }
        }

        if (list.size() < k) {
            System.out.println("0");
        } else {
            System.out.println(list.get(k - 1));
        }
    }
}
