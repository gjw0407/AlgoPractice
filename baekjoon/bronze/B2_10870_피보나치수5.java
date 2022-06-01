package baekjoon.bronze;

import java.util.Scanner;

public class B2_10870_피보나치수5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if (n == 0) {
            System.out.println("0");
        } else if (n == 1) {
            System.out.println("1");
        } else {
            System.out.println(pibo(n));
        }
    }

    public static int pibo(int n){
        if(n == 0){
            return 0;
        } else if(n == 1){
            return 1;
        }
        return pibo(n - 2) + pibo(n - 1);
    }
}
