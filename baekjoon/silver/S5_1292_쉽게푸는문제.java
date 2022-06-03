package baekjoon.silver;

import java.util.ArrayList;
import java.util.Scanner;

public class S5_1292_쉽게푸는문제 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int sum = 0;

        int a = sc.nextInt();
        int b = sc.nextInt();
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j <= i; j++) {
                list.add(i + 1);
            }
        }

        for (int i = a - 1; i <= b - 1; i++) {
            sum += list.get(i);
        }

        System.out.println(sum);
    }
}
