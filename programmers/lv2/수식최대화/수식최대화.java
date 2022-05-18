package programmers.lv2.수식최대화;

import java.util.ArrayList;

// time: 16:33
// 2022.04.25
public class 수식최대화 {
    static char[] prior = {'+', '-', '*'};
    static boolean[] check = new boolean[3];
    static long answer = 0;

    public static void main(String[] args) {
        System.out.println(solution("100-200*300-500+20"));
    }

    public static long solution(String expression) {


        ArrayList<Long> num = new ArrayList<>();
        ArrayList<Character> op = new ArrayList<>();

        String temp = "";
        for(int i = 0; i < expression.length(); i++){
            if('0' <= expression.charAt(i) && expression.charAt(i) <= '9'){
                temp += String.valueOf(expression.charAt(i));
                if(i == expression.length() - 1){
                    num.add(Long.parseLong(temp));
                }
            } else {
                num.add(Long.parseLong(temp));
                op.add(expression.charAt(i));
                temp = "";
            }
        }

        makePermutation(0, new char[3], num, op);

        return answer;
    }

    public static void makePermutation(int r, char[] p, ArrayList<Long> num, ArrayList<Character> op){
        if(r == 3){
            ArrayList<Long> nums = new ArrayList<>(num);
            ArrayList<Character> ops = new ArrayList<>(op);

            for(int i = 0; i < p.length; i++){
                for(int j = 0; j < ops.size(); j++){
                    if(p[i] == ops.get(j)){
                        Long temp = calc(nums.remove(j), nums.remove(j), p[i]);
                        nums.add(j, temp);
                        ops.remove(j);
                        j--;
                    }
                }
            }

            answer = Math.max(answer, Math.abs(nums.get(0)));
            return;
        }

        for(int i = 0; i < 3; i++){
            if(!check[i]){
                check[i] = true;
                p[r] = prior[i];
                makePermutation(r+1,p, num, op);
                check[i] = false;
            }
        }

    }

    public static Long calc(Long remove, Long remove1, char c) {
        long num = 0;
        switch (c){
            case '+':{
                return remove + remove1;
            }
            case '-':{
                return remove - remove1;
            }
            case '*':{
                return remove * remove1;
            }
        }
        return num;
    }

}
