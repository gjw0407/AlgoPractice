package programmers.lv2.메뉴리뉴얼;

import java.util.*;

// 2022.05.09
public class 메뉴리뉴얼 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2,3,4}));
        System.out.println(solution(new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}, new int[]{2,3,5}));
    }

    public static String[] solution(String[] orders, int[] course) {
        String[] answer = {};

        Set<String> tempAns = new HashSet<>();
        for (int i = 0; i < orders.length; i++){
            for(int j = 0; j < orders.length; j++){
                if(i == j) continue;

                StringBuilder sb = new StringBuilder();
                List<String> temp = new ArrayList<>();
                for(int k = 0; k < orders[j].length(); k++){
                    if(orders[i].contains(String.valueOf(orders[j].charAt(k)))){
                        sb.append(orders[j].charAt(k));
                        temp.add(String.valueOf(orders[j].charAt(k)));
                    }
                }

                if(temp.size() >= 2){
                    for(int l = 0; l < course.length; l++){
                        if(temp.size() == course[l]){
                            String tempString = sb.toString();
                            char[] StringtoChar = tempString.toCharArray();
                            Arrays.sort(StringtoChar);
                            String SortedString = new String(StringtoChar);

                            tempAns.add(SortedString);
                            break;
                        }
                    }
                }
            }
        }

        System.out.println(tempAns);
        String[] arr = tempAns.toArray(new String[0]);
        List<Integer> ccnt = new ArrayList<>();
        for(int i = 0; i < tempAns.size(); i++){
            int cnt = 0;
            for(int j = 0; j < orders.length; j++){
                if(orders[j].contains(arr[i])){
                    cnt++;
                }
            }
            ccnt.add(cnt);
        }

        System.out.println(ccnt);

        return answer;
    }
}
