package programmers.lv2.뉴스클러스터링;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 뉴스클러스터링 {
    public static void main(String[] args) {
//        System.out.println(solution("FRANCE","french"));
//        System.out.println(solution("e=m*c^2","E=M*C^2"));
//        System.out.println(solution("aa1+aa2","AAAA12"));
//        System.out.println(solution("aa1+aa2","AA12"));
        System.out.println(solution("aaabbb","aabbbe"));
//        System.out.println(solution("shake hands","handshake"));
//        System.out.println(solution("aaabc","aaaa"));
//        System.out.println(solution("aaaa","aaa"));
//        System.out.println(solution("BAAAA","AAA"));
    }

    public static int solution(String str1, String str2) {
        int answer = 0;

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        List<String> str1Sub = new ArrayList<>();
        List<String> str2Sub = new ArrayList<>();
        for(int i = 0; i < str1.length() - 1; i++){
            String temp = "";
            for(int j = i; j < i + 2; j++){
                if('a' <= str1.charAt(j) && str1.charAt(j) <= 'z'){
                    temp += String.valueOf(str1.charAt(j));
                } else {
                    break;
                }
            }
            if(temp.length() == 2){
                str1Sub.add(temp);
            }
        }

        for(int i = 0; i < str2.length() - 1; i++){
            String temp = "";
            for(int j = i; j < i + 2; j++){
                if('a' <= str2.charAt(j) && str2.charAt(j) <= 'z'){
                    temp += String.valueOf(str2.charAt(j));
                } else {
                    break;
                }
            }
            if(temp.length() == 2){
                str2Sub.add(temp);
            }
        }

        Collections.sort(str1Sub);
        Collections.sort(str2Sub);

        if(str1Sub.size() == 0 && str2Sub.size() == 0){
            return 65536;
        } else if(str1Sub.size() == 0 || str2Sub.size() == 0){
            return 0;
        }

        List<String> n = new ArrayList<>();
        List<String> u = new ArrayList<>();

        for(String s : str1Sub) {
            if(str2Sub.remove(s)) {
                n.add(s);
            }
            u.add(s);
        }

        for(String s : str2Sub) {
            u.add(s);
        }

        answer = calc(n.size(), u.size());

        return answer;
    }

    private static int calc(int a, int b){
        return (int) ( ( (double) a / (double) b ) * 65536 );
    }

}
