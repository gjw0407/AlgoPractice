package baekjoon.bronze;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class B3_10818_최소최대 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> list = new ArrayList<>();
        int T = sc.nextInt();
        int[] nums = new int[T];
        for(int t = 0; t < T; t++){
            int min = -1000001;
            int max = 1000001;

            int n = sc.nextInt();
            list.add(n);
            nums[t] = n;

        }
        Collections.sort(list);
        System.out.println(list.get(0) + " " + list.get(list.size() - 1));
    }
}
