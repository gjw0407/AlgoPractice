package programmers.lv2.카펫;

// time: 16:42
// 2022.05.26
public class 카펫 {
    static int[] answer = new int[2];
    public static void main(String[] args) {
        System.out.println(solution(8,1));
    }

    public static int[] solution(int brown, int yellow) {
        int total = brown + yellow;

        makeCombination(total, 2, 1, new int[2], yellow);

        return answer;
    }

    public static void makeCombination(int total, int r, int start, int temp[], int yellow){
        if(r == 0){
            if(temp[0] * temp[1] == total){
                for (int i = 0;i < 2; i++){
                    System.out.print(temp[i] + " ");
                }
                System.out.println();

                if((temp[0] - 2) * (temp[1] - 2) == yellow){
                    answer[0] = temp[0];
                    answer[1] = temp[1];
                    return;
                }
            }

            return;
        }

        for(int i = start; i < total; i++){
            temp[r - 1] = i;
            makeCombination(total, r - 1, i + 1, temp, yellow);
        }
    }
}
