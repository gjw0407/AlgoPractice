package inflearn.string;

import java.util.*;

public class 문장속단어 {
    public String solution(String str) {
        String answer = "";

        int m = Integer.MIN_VALUE;
        String[] s = str.split(" ");

        for (String x : s) {
            int len = x.length();
            if (len > m) {
                m = len;
                answer = x;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        문장속단어 T = new 문장속단어();
        Scanner in = new Scanner(System.in);

        String str = in.nextLine();

        System.out.println(T.solution(str));
    }
}
