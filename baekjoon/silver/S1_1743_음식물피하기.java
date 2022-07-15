package baekjoon.silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class S1_1743_음식물피하기 {
    static int N, M, K;
    static int map[][];
    static boolean visited[][];
    static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();
        K = scanner.nextInt();

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int k = 0; k < K; k++) {
            int a = scanner.nextInt() - 1;
            int b = scanner.nextInt() - 1;

            map[a][b] = 1;
        }

        int answer = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (map[r][c] == 1 && !visited[r][c]) {
                    visited[r][c] = true;
                    answer = Math.max(answer, bfs(r, c));
                }
            }
        }

        System.out.println(answer);
    }

    public static class Now {
        int r, c;

        public Now(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private static boolean isIn(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < M;
    }


    public static int bfs(int r, int c) {
        int cnt = 1;
        Queue<Now> q = new LinkedList<>();
        q.add(new Now(r, c));

        while (!q.isEmpty()) {
            Now n = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = n.r + dirs[i][0];
                int nc = n.c + dirs[i][1];

                if (isIn(nr, nc)) {
                    if (map[nr][nc] == 1 && !visited[nr][nc]) {
                        cnt++;
                        visited[nr][nc] = true;
                        q.offer(new Now(nr, nc));
                    }
                }
            }
        }

        return cnt;
    }

}
