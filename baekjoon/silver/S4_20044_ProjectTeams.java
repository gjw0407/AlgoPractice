package baekjoon.silver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class S4_20044_ProjectTeams {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int teams = sc.nextInt();

		int members[] = new int[teams * 2];
		for (int i = 0; i < 2 * teams; i++) {
			members[i] = sc.nextInt();
		}

		Arrays.sort(members);
		int min = 987654321;

		for (int i = 0; i < teams; i++) {
			int teamScore = members[i] + members[teams * 2 - 1 - i];
			if (teamScore < min) {
				min = teamScore;
			}
		}

		System.out.println(min);

	}
}
