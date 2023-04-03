package inflearn.hashMapTreeMap;

import java.util.HashMap;
import java.util.Scanner;

public class 학급회장 {
    public char solution(int n, String input) {
        char answer = ' ';
        HashMap<Character, Integer> map = new HashMap<>();
        for (char x : input.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        int max = Integer.MIN_VALUE;
        for (char key : map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
                answer = key;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        학급회장 T = new 학급회장();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String input = in.next();
        System.out.print(T.solution(n, input));
    }
}
