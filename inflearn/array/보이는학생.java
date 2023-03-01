package inflearn.array;

import java.util.Scanner;

public class 보이는학생 {
    public int solution(int n, int[] arr) {
        int answer = 1;

        int teacher = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > teacher) {
                answer++;
                teacher = arr[i];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        보이는학생 T = new 보이는학생();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.print(T.solution(n, arr));
    }
}
