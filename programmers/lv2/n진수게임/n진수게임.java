package programmers.lv2.n진수게임;

// time: ?
// 2022.05.19
public class n진수게임 {
    public static void main(String[] args) {
        System.out.println(solution(16, 16, 2, 1));
    }

    public static String solution(int n, int t, int m, int p) {

        String str = "0";
        int cnt = 0;

        while (str.length() < (t * m + p)) {
            String byNum = "";
            int num = cnt++;

            while (num != 0) {
                if (num % n >= 10) {
                    byNum += String.valueOf((char) (num % n + 55));
                } else {
                    byNum += String.valueOf(num % n);
                }
                num = num / n;
            }
            str += new StringBuffer(byNum).reverse().toString();
        }

        String answer = "";

        for (int i = 0; i < t; i++) {
            answer += String.valueOf(str.charAt(m * i + p - 1));
        }

        return answer;
    }
}
