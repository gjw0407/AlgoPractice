package inflearn.string;

import java.util.*;

public class 회문문자열 {
    public String solution(String str) {
        String answer = "NO";

//        str = str.toLowerCase();
//        for (int i = 0; i < str.length() / 2; i++) {
//            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
//                return "NO";
//            }
//        }

        String temp = new StringBuilder(str).reverse().toString();
        // ignorecase -> 대소문자 무시
        if (str.equalsIgnoreCase(temp)) {
            return "YES";
        }

        return answer;
    }

    public static void main(String[] args) {
        회문문자열 T = new 회문문자열();
        Scanner in = new Scanner(System.in);
        String str = in.next();
        System.out.println(T.solution(str));
    }
}
