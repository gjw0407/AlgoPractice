package Programmers.신규아이디추천;

import java.util.Locale;

// failed
// prob: 2번째 조건문
// 2022.04.17
// time: 19:42
public class 신규아이디추천 {
    public static void main(String[] args) {
        solution("...!@BaT#*..y.abcdefghijklm");
    }

    static public String solution(String new_id) {
        String answer = "";

        // 1
        answer = new_id.toLowerCase();
        System.out.println(answer + " " + 1);

        // 2
        answer = answer.replaceAll("[^a-z0-9-_.]","");

        // 3
        while(answer.contains("..")){
            answer = answer.replace("..",".");
        }
        System.out.println(answer + " " + 3);

        // 4
        if(answer.charAt(0) == '.'){
            answer = answer.substring(1, answer.length());
        }

        if(answer.endsWith(".")){
            answer = answer.substring(0, answer.length() - 1);
        }

        System.out.println(answer + " " + 4);

        // 5
        if(answer.length() == 0){
            answer += "a";
        }

        System.out.println(answer + " " + 5);

        // 6
        if(answer.length() >= 16){
            answer = answer.substring(0, 15);
            if(answer.endsWith(".")){
                answer = answer.substring(0, 14);
            }
        }

        System.out.println(answer + " " + 6);

        // 7
        while(answer.length() <= 2){
            answer += answer.substring(answer.length() - 1);
        }

        System.out.println(answer + " " + 7);

        return answer;
    }
}
