package Programmers.Lv2.튜플;

import java.util.*;

// time: 1:03:08
// 2022.04.26
public class 튜플 {
    static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(solution("{{20,111},{111}}"));
    }

    public static List<Integer> solution(String s){
        List<List<Integer>> nums = new ArrayList<>();
        for(int i = 1; i < s.length() - 1; i++){
            if(s.charAt(i) == '{'){
                String temp = "";
                List<Integer> tempList = new ArrayList<>();
                for(int j = i + 1; j < s.length() - 1; j++){
                    if('0' <= s.charAt(j) && s.charAt(j) <= '9'){
                        temp += String.valueOf(s.charAt(j));
                    } else if(s.charAt(j) == '}'){
                        tempList.add(Integer.parseInt(temp));
                        if(tempList.size() == 1){
                            answer.add(tempList.get(0));
                        }  else {
                            nums.add(tempList);
                        }
                        i = j;
                        break;
                    } else if(s.charAt(j) == ','){
                        tempList.add(Integer.parseInt(temp));
                        temp = "";
                    }
                }
            }
        }

        order(nums, 2);

        return answer;
    }

    public static void order(List<List<Integer>> num, int size){
        while(true){
            if(num.isEmpty()){
                break;
            }

            for(int i = 0; i < num.size(); i++){
                if(num.get(i).size() == size){
                    for(int j = 0; j < num.get(i).size(); j++){
                        if(!answer.contains(num.get(i).get(j))){
                            answer.add(num.get(i).get(j));
                        }
                    }
                    num.remove(i);
                    i--;
                    size++;
                    break;
                }
            }
        }
    }

}
