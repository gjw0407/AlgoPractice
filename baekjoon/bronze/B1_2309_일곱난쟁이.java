package baekjoon.bronze;

import java.util.Arrays;
import java.util.Scanner;

public class B1_2309_일곱난쟁이 {
    static int[] heights;
    static int cntC;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        heights = new int[9];
        for (int i = 0; i < 9; i++) {
            heights[i] = sc.nextInt();
            cntC += heights[i];
        }

        Arrays.sort(heights);

        int a = 0;
        int b = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if(cntC - heights[i] - heights[j] == 100){
                    a = heights[i];
                    b = heights[j];
                }
            }
        }

        for(int i = 0; i < 9; i++){
            if(heights[i] == a || heights[i] == b){
                continue;
            }
            System.out.println(heights[i]);
        }
    }

}
