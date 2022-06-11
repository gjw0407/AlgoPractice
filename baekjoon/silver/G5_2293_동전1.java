package baekjoon.silver;

import java.util.Scanner;

public class G5_2293_동전1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int coin[] = new int[n];
        int dp[] = new int[k + 1];

        for (int i = 0; i < n; i++) {
            coin[i] = sc.nextInt();
        }
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                if (j >= coin[i]) {
                    dp[j] += dp[j - coin[i]];
                }
            }
        }

        System.out.println(dp[k]);

    }
}
