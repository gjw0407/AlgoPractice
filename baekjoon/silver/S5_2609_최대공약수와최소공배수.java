package baekjoon.silver;

import java.util.Scanner;

public class S5_2609_최대공약수와최소공배수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int max = 1;
        int min = 0;
        for (int i = 2; i <= a * b; i++) {
            if (a % i == 0 && b % i == 0) {
                if (i > max) {
                    max = i;
                }
            }
        }

        min = max * (a / max) * (b / max);

        System.out.println(max);
        System.out.println(min);

    }

}
