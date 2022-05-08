package Programmers.Lv2.괄호변환;

// time: 28:09
// 2022.05.08
public class 괄호변환 {
    public static void main(String[] args) {
        System.out.println(solution("(()())()"));
    }

    public static String solution(String p) {
        return correct(p);
    }

    public static String correct(String given){
        if(given.length() == 0){
            return "";
        }

        int cut = divide(given);
        String u = given.substring(0, cut);
        String v = given.substring(cut, given.length());

        if(isCorrect(u)){
            return u + correct(v);
        } else {
            String temp = "";
            temp += "(";
            temp += correct(v);
            temp += ")";
            u = u.substring(1, u.length() - 1);
            u = reverse(u);
            return temp + u;
        }
    }

    public static String reverse(String u){
        StringBuilder st = new StringBuilder();
        for (int i = 0; i < u.length(); i++){
            if(u.charAt(i) == '('){
                st.append(')');
            } else if(u.charAt(i) == ')'){
                st.append('(');
            }
        }

        return st.toString();
    }

    public static boolean isCorrect(String v){
        int left = 0;
        for(int i = 0; i < v.length(); i++){
            if(v.charAt(i) == '('){
                left++;
            } else {
                left--;
            }

            if(left < 0){
                return false;
            }
        }

        return true;
    }


    public static int divide(String given){
        int start = 0;

        int left = 0;
        int right = 0;
        for(int i = 0; i < given.length(); i++){
            if(given.charAt(i) == '('){
                left++;
            } else {
                right++;
            }

            if(left == right){
                start = i + 1;
                break;
            }
        }

        return start;
    }
}
