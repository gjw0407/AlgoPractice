package Programmers;

import java.util.ArrayList;
import java.util.List;

// time: 51:41
// 2022.04.15
public class 신고결과받기 {
    static String[] id_list = {"muzi", "frodo", "apeach", "neo"};
    static String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
    static int k = 2;

    static boolean map[][];
    public static void main(String[] args) {
        System.out.println(solution(id_list, report, k));
    }

    static public List<Integer> solution(String[] id_list, String[] report, int k) {
        List<Integer> answer = new ArrayList<>();

         map = new boolean[id_list.length][id_list.length];
         for(int i = 0; i < report.length; i++){
             String[] rep = report[i].split(" ");
             int from = findNum(rep[0], id_list);
             int to = findNum(rep[1], id_list);

             map[from][to] = true;
         }

         int[] cnt = new int[id_list.length];

         for(int c = 0 ;c < map[0].length; c++){
            for(int r = 0; r < map.length; r++){
                if(map[r][c]){
                    cnt[c]++;
                }
            }
         }

        List<Integer> ban = new ArrayList<>();
        for(int i = 0; i < cnt.length; i++){
            if(cnt[i] >= k){
                ban.add(i);
            }
        }

        for(int r = 0; r < id_list.length; r++){
            int ans = 0;
            for(int c = 0; c < id_list.length; c++){
                if(map[r][c]){
                    for(int i = 0; i < ban.size(); i++){
                        if(c == ban.get(i)){
                            ans++;
                        }
                    }
                }
            }
            answer.add(ans);
        }

        return answer;
    }

    static public int findNum(String name, String[] id_list){
        int re = 0;
       for(int i = 0; i < id_list.length; i++){
           if(id_list[i].equals(name)){
               re= i;
           }
       }
       return re;
    }


}
