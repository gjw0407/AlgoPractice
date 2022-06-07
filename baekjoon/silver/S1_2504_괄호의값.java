package baekjoon.silver;

import java.util.Scanner;
import java.util.Stack;

public class S1_2504_괄호의값 {
    static String st;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        st = sc.next();

        int cntBig = 0;
        int cntSmall = 0;
        for (int i = 0; i < st.length(); i++) {
            if (st.charAt(i) == '(') {
                cntSmall++;
            } else if (st.charAt(i) == ')') {
                cntSmall--;
            } else if (st.charAt(i) == '[') {
                cntBig++;
            } else {
                cntBig--;
            }
        }
        Stack<Character> stack = new Stack<>();
        int cnt = 1;
        int answer = 0;
        if (cntSmall != 0 || cntBig != 0) {
            System.out.println("0");
        } else {
            for (int i = 0; i < st.length(); i++) {
                if (st.charAt(i) == '(') {
                    stack.push('(');
                    cnt *= 2;
                } else if (st.charAt(i) == '[') {
                    stack.push('[');
                    cnt *= 3;
                } else {
                    if (st.charAt(i) == ')') {
                        if (stack.isEmpty() || stack.peek() != '(') {
                            break;
                        }
                        if (st.charAt(i - 1) == '(') {
                            answer += cnt;
                        }
                        stack.pop();
                        cnt /= 2;
                    } else if (st.charAt(i) == ']') {
                        if (stack.isEmpty() || stack.peek() != '[') {
                            break;
                        }
                        if (st.charAt(i - 1) == '[') {
                            answer += cnt;
                        }
                        stack.pop();
                        cnt /= 3;
                    } else {
                        break;
                    }
                }
            }
            System.out.println(answer);
        }
    }

}
