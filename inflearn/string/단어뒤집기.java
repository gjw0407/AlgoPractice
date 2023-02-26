package inflearn.string;

import java.util.*;

public class 단어뒤집기 {
    public ArrayList<String> solution(int n, String[] str) {
        ArrayList<String> answer = new ArrayList<>();

        // String은 값을 넣을 때마다 새롭게 생성되기 때문에 메모리 낭비 됨
        // StringBuilder는 이런 리스크가 없음
//        for(String x : str){
//            String temp = new StringBuilder(x).reverse().toString();
//            answer.add(temp);
//        }

        for (String x : str) {
            char[] s = x.toCharArray();
            int lt = 0;
            int rt = x.length() - 1;
            while (lt < rt) {
                char temp = s[lt];
                s[lt] = s[rt];
                s[rt] = temp;
                lt++;
                rt--;
            }
            String temp = String.valueOf(s);
            answer.add(temp);
        }

        return answer;
    }

    public static void main(String[] args) {
        단어뒤집기 T = new 단어뒤집기();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = in.next();
        }

        for (String x : T.solution(n, str)) {
            System.out.println(x);
        }
    }
}
