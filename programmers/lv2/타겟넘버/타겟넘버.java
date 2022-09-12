package programmers.lv2.타겟넘버;

import java.util.ArrayList;
import java.util.List;

public class 타겟넘버 {
    int answer = 0;

    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, target, 0);

        return answer;
    }

    public void dfs(int[] numbers, int depth, int target, int sum){
        if(depth == numbers.length){
            if(target == sum) answer++;
        } else {
            dfs(numbers, depth + 1, target, sum + numbers[depth]);
            dfs(numbers, depth + 1, target, sum - numbers[depth]);
        }
    }

}
