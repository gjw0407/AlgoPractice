package baekjoon.silver;

import java.util.Scanner;

public class S4_1543_문서검색 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String target = sc.nextLine();
		String find = sc.nextLine();

		int answer = 0;
		for (int i = 0; i < target.length() - find.length() + 1; i++) {
			if (target.substring(i, i + find.length()).equals(find)) {
				i += find.length() - 1;
				answer++;
			}
		}
		System.out.println(answer);

	}
}
