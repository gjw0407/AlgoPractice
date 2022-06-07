package baekjoon.silver;

import java.util.Scanner;

public class S5_1789_수들의합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double S = sc.nextDouble();

        double tot = 0;
        int answer = 1;
        while(true){
            tot = (double)answer * (double)(answer + 1) / (double)2;

            if(tot > S){
                break;
            }

            answer++;
        }
        System.out.println(answer - 1);
    }
}
