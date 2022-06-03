package baekjoon.silver;

import java.util.Scanner;

public class S4_1978_소수찾기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int cnt = 0;
        for(int i = 0; i < N; i++){
            int a = sc.nextInt();
            if(a == 1){
                cnt++;
                continue;
            }
            for(int j = 2; j < a; j++){
                if(a % j == 0){
                    cnt++;
                    break;
                }
            }
        }
        System.out.println(N - cnt);
    }
}
