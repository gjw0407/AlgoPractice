package inflearn.string;

import java.util.*;

public class 문자열압축 {
    public String solution(String s) {
        String answer = "";
        s += " ";
//        for (int i = 0; i < s.length() - 1; i++) {
//            char temp = s.charAt(i);
//            int cnt = 1;
//            for (int j = i + 1; j < s.length(); j++) {
//                if (s.charAt(j) == temp) {
//                    cnt++;
//                } else {
//                    i = j - 1;
//                    break;
//                }
//            }
//            if (cnt != 1) {
//                answer = answer + temp + String.valueOf(cnt);
//            } else {
//                answer += temp;
//            }
//        }
        int cnt = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                cnt++;
            } else {
                answer += s.charAt(i);
                if (cnt > 1) {
                    answer += String.valueOf(cnt);
                    cnt = 1;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        문자열압축 T = new 문자열압축();
        Scanner in = new Scanner(System.in);
        String s = in.next();
        System.out.print(T.solution(s));
    }
}
