package programmers.lv2.압축;

import java.util.ArrayList;
import java.util.HashMap;

// time: 18:03
// 2022.05.21
public class 압축 {
    public static void main(String[] args) {
        System.out.println(solution("TOBEORNOTTOBEORTOBEORNOT"));
    }

    private static int[] solution(String msg) {
        int[] answer = {};
        HashMap<String, Integer> dict = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();

        int dictIdx = 1;
        for (int i = 'A'; i <= 'Z'; i++) {
            dict.put(String.valueOf((char) i), dictIdx++);
        }

        int idx = 0;
        while (idx < msg.length()) {
            String w = "";
            while (idx < msg.length()) {
                if (!dict.containsKey(w + msg.charAt(idx))) {
                    break;
                } else {
                    w += msg.charAt(idx);
                }
                idx++;
            }

            ans.add(dict.get(w));
            if (idx < msg.length()) {
                dict.put(w + msg.charAt(idx), dictIdx++);
            }
        }

        answer = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }

        return answer;
    }

}
