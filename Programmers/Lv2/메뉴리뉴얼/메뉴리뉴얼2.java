package Programmers.Lv2.메뉴리뉴얼;

import java.util.*;

// 2022.05.09
public class 메뉴리뉴얼2 {

    static HashMap<String, Integer> map;
    static int m;

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2, 3, 4}));
        System.out.println(solution(new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}, new int[]{2, 3, 5}));
    }

    public static String[] solution(String[] orders, int[] course) {

        PriorityQueue<String> pq = new PriorityQueue<>();
        for (int i = 0; i < course.length; i++) {
            map = new HashMap<>();
            m = 0;
            for (int j = 0; j < orders.length; j++) {
                combination(0, "", course[i], 0, orders[j]);
            }
            for (String s : map.keySet()) {
                if (map.get(s) == m && m > 1) {
                    pq.offer(s);
                }
            }
        }

        String ans[] = new String[pq.size()];
        int k = 0;
        while (!pq.isEmpty()) {
            ans[k++] = pq.poll();
        }

        return ans;
    }

    public static void combination(int cnt, String str, int targetNum, int idx, String word) {
        if (cnt == targetNum) {
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String temps = "";
            for (int i = 0; i < c.length; i++) {
                temps += c[i];
            }
            map.put(temps, map.getOrDefault(temps, 0) + 1);
            m = Math.max(m, map.get(temps));
            return;
        }
        for (int i = idx; i < word.length(); i++) {
            char now = word.charAt(i);
            combination(cnt + 1, str + now, targetNum, i + 1, word);
        }
    }
}
