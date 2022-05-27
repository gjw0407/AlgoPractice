package programmers.lv1.체육복;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// time: 17:52
// 2022.05.27
public class 체육복 {
    public static void main(String[] args) {
        System.out.println(solution(5, new int[]{2, 4}, new int[]{1, 6, 5}));
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;

        Arrays.sort(lost);
        Arrays.sort(reserve);

        for(int i = 0; i < lost.length; i++){
            for(int j = 0; j < reserve.length; j++){
                if(lost[i] == reserve[j]){
                    answer++;
                    lost[i] = 0;
                    reserve[i] = 0;
                    break;
                }
            }
        }

        for(int i = 0; i < lost.length; i++){
            for(int j = 0; j < reserve.length; j++){
                if(lost[i] - 1 == reserve[j] || lost[i] + 1 == reserve[j]){
                    answer++;
                    reserve[i] = 0;
                    break;
                }
            }
        }

        return answer;
    }

}

