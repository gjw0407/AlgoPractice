package Programmers.Lv2.단체사진찍기;

// time: 24:59
// 2022.04.30
public class 단체사진찍기 {
    static String names[] ={"A", "C", "F", "J", "M", "N", "R", "T"};
    static int answer = 0;

    public static void main(String[] args) {
        System.out.println(solution(2, new String[]{"N~F=0", "R~T>2"}));
    }

    public static int solution(int n, String[] data) {

        boolean []visited = new boolean[8];
        makePermutation("", data, visited);

        return answer;
    }

    private static void makePermutation(String nms, String[] data, boolean []visited) {

        if(nms.length() == 7){
            System.out.println(nms);
            answer += check(data, nms);
            return;
        }

        for(int i = 0; i < 8; i++){
            if(!visited[i]){
                visited[i] = true;
                String name = nms + names[i];
                makePermutation(name, data, visited);
                visited[i] = false;
            }
        }

    }

    private static int check(String[] data, String nms){

        for(int i = 0; i < data.length; i++){
            int start = nms.indexOf(data[i].charAt(0));
            int end = nms.indexOf(data[i].charAt(2));
            char op = data[i].charAt(3);
            int num = data[i].charAt(4) - '0';

            if(op == '='){
                if(!(Math.abs(start - end) == num+1)){
                    return 0;
                }
            } else if(op == '>'){
                if(!(Math.abs(start - end) > num+1)){
                    return 0;
                }
            } else {
                if(!(Math.abs(start - end) < num+1)){
                    return 0;
                }
            }
        }

        return 1;
    }
}
