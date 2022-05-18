package programmers.lv2.순위검색;

import java.util.ArrayList;
import java.util.List;

// time: 37:32
// 2022.04.28
public class 순위검색 {

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"},
                new String[]{"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"}));
    }

    public static List<Integer> solution(String[] info, String[] query) {
        List<Integer> answer = new ArrayList<>();

        List<List<String>> list = new ArrayList<>();
        List<List<String>> list2 = new ArrayList<>();
        for(int i = 0; i < query.length; i++){
            List<String> tempL = new ArrayList<>();
            String temp = "";
            for(int j = 0; j < query[i].length(); j++){
                if(query[i].charAt(j) != ' '){
                    temp += String.valueOf(query[i].charAt(j));
                } else {
                    if(temp.equals("and")){
                        temp = "";
                        continue;
                    }
                    tempL.add(temp);
                    temp = "";
                }
            }
            tempL.add(temp);
            list.add(tempL);
        }

        for(int i = 0; i < info.length; i++){
            List<String> tempL = new ArrayList<>();
            String temp = "";
            for(int j = 0; j < info[i].length(); j++){
                if(info[i].charAt(j) != ' '){
                    temp += String.valueOf(info[i].charAt(j));
                } else{
                    tempL.add(temp);
                    temp = "";
                }
            }
            tempL.add(temp);
            list2.add(tempL);
        }

        for(int i = 0; i < list.size(); i++){
            int ans = 0;
        for(int j = 0; j < list2.size(); j++){
                int cnt = 0;
                for(int k = 0; k < 4; k++){
                    if(!list.get(i).get(k).equals("-")){
                        if(list.get(i).get(k).equals(list2.get(j).get(k))){
                            cnt++;
                        } else {
                            break;
                        }
                    } else {
                        cnt++;
                    }
                }
                if(Integer.parseInt(list.get(i).get(4)) <= Integer.parseInt(list2.get(j).get(4))){
                    cnt++;
                }
                if(cnt == 5){
                    ans++;
                }
            }
            answer.add(ans);
        }

        return answer;
    }
}
