package programmers.lv2.위장;

import java.util.HashMap;
import java.util.Set;

public class 위장 {
    public static void main(String[] args) {
        System.out.println(solution(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}));
    }

    public static int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String, Integer> clothesMap = new HashMap<String, Integer>();

        for (int i = 0; i < clothes.length; i++) {
            clothesMap.put(clothes[i][1], clothesMap.getOrDefault(clothes[i][1], 0) + 1);
        }

        Set<String> keySet = clothesMap.keySet();

        for (String key : keySet) {
            answer *= clothesMap.get(key) + 1;
        }
        return answer - 1;
    }
}
