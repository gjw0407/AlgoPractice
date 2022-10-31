package baekjoon.silver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class S4_2217_로프 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			list.add(sc.nextInt());
		}

		Collections.sort(list);
		
		int max = list.get(list.size() - 1);

        for (int i = 0; i < N; i++) {
            max = Math.max(max, list.get(i) * (N - i));
        }
        
        System.out.println(max);
        
	}

}
