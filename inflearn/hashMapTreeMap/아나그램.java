package inflearn.hashMapTreeMap;

import java.util.HashMap;
import java.util.Scanner;

public class 아나그램 {
    public String solution(String n, String m) {
        String answer = "YES";

        HashMap<Character, Integer> map = new HashMap<>();
        for (char x : n.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        for (char x : m.toCharArray()) {
            if (!map.containsKey(x) || map.get(x) == 0) {
                return "NO";
            }
            map.put(x, map.get(x) - 1);
        }


        return answer;
    }

    public static void main(String[] args) {
        아나그램 T = new 아나그램();
        Scanner in = new Scanner(System.in);
        String n = in.next();
        String m = in.next();
        System.out.print(T.solution(n, m));
    }
}
