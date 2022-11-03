package baekjoon.silver;

import java.util.Scanner;

public class S2_11501_주식 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		long ans[] = new long[T];
		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();

			long stocks[] = new long[N];
			for (int i = 0; i < N; i++) {
				stocks[i] = sc.nextInt();
			}

			long answer = 0;
			for (int i = N - 1; i >= 0; i--) {
				if (stocks[i] > answer) {
					answer = stocks[i];
				} else {
					ans[t] += (answer - stocks[i]);
				}
			}
		}
		
		for(int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}
	}

}
