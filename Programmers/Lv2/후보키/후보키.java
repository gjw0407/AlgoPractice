package Programmers.Lv2.후보키;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

// time: 13:07
// 2022.04.28
public class 후보키 {
    static ArrayList<HashSet<Integer>> candidateKey;

    public static void main(String[] args) {
        System.out.println(solution(new String[][]{{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},
                {"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}}));
    }

    public static int solution(String[][] relation) {
        candidateKey = new ArrayList<>();
        int colSize = relation[0].length;

        for(int i = 1 ; i <= colSize ; ++i) {
            makeKeySet(-1, colSize - 1, 0, i, new HashSet<>(), relation);
        }

        return candidateKey.size();
    }

    private static void makeKeySet(int attr, int maxAttr, int idx, int size, HashSet<Integer> keySet, String[][] relation) {
        if(idx == size) {

            for(int i : keySet) System.out.print(i + " ");

            for(HashSet<Integer> key : candidateKey) {
                if(keySet.containsAll(key)) {
                    System.out.println("는 " + key + "를 포함합니다.");
                    return;
                }
            }

            if(isUnique(keySet, relation)) {
                System.out.println("는 후보키 입니다.");
                candidateKey.add(keySet);
            } else {
                System.out.println("는 후보키가 아닙니다.");
            }

            return;
        }

        for(int i = attr + 1 ; i <= maxAttr ; ++i) {
            HashSet<Integer> newKeySet = new HashSet<>(keySet);
            newKeySet.add(i);
            makeKeySet(i, maxAttr, idx + 1, size, newKeySet, relation);
        }
    }

    private static boolean isUnique(HashSet<Integer> keySet, String[][] relation) {
        HashMap<String, String> map = new HashMap<>();

        for(int r = 0 ; r < relation.length ; ++r) {
            String key = "";

            for(int c : keySet) {
                key += relation[r][c];
            }
            System.out.println(key + " key");

            if(map.containsKey(key)) return false;
            else map.put(key, key);
        }
            System.out.println(map);

        return true;
    }
}
