package inflearn.string;

import java.util.*;

public class 숫자만추출 {
    public int solution(String str) {
        int answer = 0;
        String tempAnswer = "";
        for (char x : str.toCharArray()) {
            // ASCI 숫자 범위 0-9
//            if (x >= 48 && x <= 57) {
//                answer = answer * 10 + (x - 48);
//            }
            if (Character.isDigit(x)) {
                tempAnswer += x;
            }
        }

        answer = Integer.parseInt(tempAnswer);
        return answer;
    }

    public static void main(String[] args) {
        숫자만추출 T = new 숫자만추출();
        Scanner in = new Scanner(System.in);
        String str = in.next();
        System.out.println(T.solution(str));
    }
}
