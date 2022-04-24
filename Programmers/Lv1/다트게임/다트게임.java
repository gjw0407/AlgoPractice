package Programmers.Lv1.다트게임;

import java.util.Stack;

// time: 1:04:59
// 2022.04.24
public class 다트게임 {
    public static void main(String[] args) {
        System.out.println(solution("1S*2T*3S"));
    }

    static public int solution(String dartResult) {
        int answer = 0;
        int[] round = new int[3];
        String tempS = "";
        int tempNum = 0;
        int idx = 0;

        for(int i = 0; i < dartResult.length(); i++){
            char c = dartResult.charAt(i);

            if('0' <= c && c <= '9'){
                tempS += String.valueOf(c);
            } else if(c == 'S' || c == 'D' || c == 'T'){
                tempNum = Integer.parseInt(tempS);
                if(c == 'S'){
                    tempNum = (int) Math.pow(tempNum , 1);
                } else if(c == 'D'){
                    tempNum = (int) Math.pow(tempNum , 2);
                } else {
                    tempNum = (int) Math.pow(tempNum , 3);
                }
                round[idx++] = tempNum;
                tempS = "";
            } else {
                if(c == '#'){
                    round[idx - 1] *= -1;
                } else {
                    round[idx - 1] *= 2;
                    if(idx - 2 >= 0){
                        round[idx - 2] *= 2;
                    }
                }
            }
        }

        for(int i = 0; i < round.length; i++){
            answer += round[i];
        }

        return answer;
    }
}
