package baekjoon.bronze;

import java.util.Scanner;

public class B3_2460_지능형기차2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int max = -1;
        int ppl = 0;
        for(int i = 0; i < 10; i++){
            int out = sc.nextInt();
            int in = sc.nextInt();

            ppl = ppl - out;
            ppl = ppl + in;

            if(ppl > max){
                max = ppl;
            }
        }

        System.out.println(max);
    }
}
