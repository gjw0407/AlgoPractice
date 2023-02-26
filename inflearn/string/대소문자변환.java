package inflearn.string;

import java.util.*;

public class 대소문자변환 {
    public String solution(String str) {
        String answer = "";

        for (int i = 0; i < str.length(); i++) {
            if (Character.isLowerCase(str.charAt(i))) {
                answer += Character.toUpperCase(str.charAt(i));
            } else {
                answer += Character.toLowerCase(str.charAt(i));
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        대소문자변환 T = new 대소문자변환();
        Scanner in = new Scanner(System.in);

        String str = in.next();

        System.out.println(T.solution(str));
    }
}
