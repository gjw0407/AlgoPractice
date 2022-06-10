package baekjoon.silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class S1_2178_미로탐색 {
    static int[][] map;
    static int N, M;
    static boolean[][] visited;
    static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int r = 0; r < N; r++) {
            String st = sc.next();
            for (int c = 0; c < M; c++) {
                map[r][c] = st.charAt(c) - '0';
            }
        }

        bfs();
        System.out.println(map[N-1][M-1]);
    }

    public static class Now {
        int r, c;
        int cnt;

        public Now(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    public static void bfs() {
        Queue<Now> q = new LinkedList<>();
        q.offer(new Now(0, 0, 1));
        visited[0][0] = true;

        while (!q.isEmpty()) {
            Now now = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = now.r + dirs[d][0];
                int nc = now.c + dirs[d][1];

                if (isIn(nr, nc)) {
                    if (map[nr][nc] == 1 && !visited[nr][nc]) {
                        q.offer(new Now(nr, nc, now.cnt++));
                        map[nr][nc] = map[now.r][now.c] + 1;
                        visited[nr][nc] = true;
                    }
                }
            }
        }

    }

    private static boolean isIn(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < M;
    }
}
