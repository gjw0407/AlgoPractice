package programmers.lv2.소수찾기;

import java.util.ArrayList;

public class 소수찾기 {
    static int answer = 0;
    static boolean[] check = new boolean[10];
    static ArrayList<Integer> arr = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(solution("101"));
    }

    public static int solution(String numbers) {
        String temp = "";
        for (int i = 0; i < numbers.length(); i++) {
            make(numbers, i + 1, temp);
        }

        for (int i = 0; i < arr.size(); i++) {
            if (check(arr.get(i))) {
                answer++;
            }
        }
        return answer;
    }

    public static void make(String number, int m, String temp) {
        if (temp.length() == m) {
            int num = Integer.parseInt(temp);
            System.out.println(temp);
            if (!arr.contains(num)) {
                arr.add(num);
            }
            return;
        } else {
            for (int i = 0; i < number.length(); i++) {
                if (!check[i]) {
                    check[i] = true;
                    temp += number.charAt(i);
                    make(number, m, temp);
                    check[i] = false;
                    temp = temp.substring(0, temp.length() - 1);
                }
            }
        }

    }

    public static boolean check(int possible) {
        if (possible == 0 || possible == 1) {
            return false;
        }

        for (int i = 2; i < possible; i++) {
            if (possible % i == 0) {
                return false;
            }
        }

        return true;
    }
}
