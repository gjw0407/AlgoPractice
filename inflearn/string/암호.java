package inflearn.string;

import java.util.*;

public class 암호 {
    public String solution(int n, String s) {
        String answer = "";

        for (int i = 0; i < n; i++) {
            String temp = s.substring(0, 7).replace('#', '1').replace('*', '0');

            int num = Integer.parseInt(temp, 2);
            answer += (char) num;

            s = s.substring(7);
        }

        return answer;
    }

    public static void main(String[] args) {
        암호 T = new 암호();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        System.out.print(T.solution(n, s));
    }
}
