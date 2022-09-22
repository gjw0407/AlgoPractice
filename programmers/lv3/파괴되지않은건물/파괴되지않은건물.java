package programmers.lv3.파괴되지않은건물;

public class 파괴되지않은건물 {
    static int[][] sum;
    static int N, M;

	public static void main(String[] args) {
		System.out.println(solution(new int[][] { {1,2,3},{4,5,6,},{7,8,9,} }, new int[][]{{1,1,1,2,2,4},{1,0,0,1,1,2},{2,2,0,2,0,100}));
	}

	public static int solution(int[][] board, int[][] skill) {
	    N = board.length;
        M = board[0].length;

        sum = new int[N + 1][M + 1];
        for (int[] s : skill) {
            int y1 = s[1], x1 = s[2];
            int y2 = s[3], x2 = s[4];
            int degree = s[5] * (s[0] == 1 ? -1 : 1);

            sum[y1][x1] += degree;
            sum[y1][x2 + 1] += (degree * -1);
            sum[y2 + 1][x1] += (degree * -1);
            sum[y2 + 1][x2 + 1] += degree;
        }
        operate();

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] + sum[i][j] > 0) answer++;
            }
        }
        return answer;
    }

    public static void operate() {
        for (int y = 1; y < N; y++) {
            for (int x = 0; x < M; x++) {
                sum[y][x] += sum[y - 1][x];
            }
        }

        for (int x = 1; x < M; x++) {
            for (int y = 0; y < N; y++) {
                sum[y][x] += sum[y][x - 1];
            }
        }
    }
}
