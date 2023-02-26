package inflearn.string;

import java.util.*;

public class 팰린드롬 {
    public String solution(String str) {
        String answer = "NO";
        str = str.toUpperCase().replaceAll("[^A-Z]", "");
        String temp = new StringBuilder(str).reverse().toString();
        if (str.equals(temp)) answer = "YES";

        return answer;
    }

    public static void main(String[] args) {
        팰린드롬 T = new 팰린드롬();
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(T.solution(str));
    }
}
