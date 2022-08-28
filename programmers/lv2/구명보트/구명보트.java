package programmers.lv2.구명보트;

import java.util.Arrays;

public class 구명보트 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{70, 50, 80, 50}, 100));
    }

    public static int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);

        int min = 0;

        for (int max = people.length - 1; max >= min; max--) {
            if (people[min] + people[max] <= limit) {
                min++;
            }
            answer++;
        }

        return answer;
    }
}
