package baekjoon.silver;

import java.util.*;

public class S1_2667_단지번호붙이기 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();

        map = new int[N][N];
        for (int r = 0; r < N; r++) {
            String s = scanner.next();
            for (int c = 0; c < N; c++) {
                map[r][c] = s.charAt(c) - '0';
            }
        }
        visited = new boolean[N][N];
        int answer = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (map[r][c] == 1 && !visited[r][c]) {
                    visited[r][c] = true;
                    answer++;
                    list.add(bfs(r, c));
                }
            }
        }

        Collections.sort(list);

        System.out.println(answer);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }

    public static class Now {
        int r, c;

        public Now(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static int bfs(int r, int c) {
        Queue<Now> q = new LinkedList<>();
        q.offer(new Now(r, c));
        int cnt = 1;

        while (!q.isEmpty()) {
            Now now = q.poll();

            for (int d = 0; d < dirs.length; d++) {
                int nr = now.r + dirs[d][0];
                int nc = now.c + dirs[d][1];

                if (isIn(nr, nc)) {
                    if (map[nr][nc] == 1 && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        cnt++;
                        q.offer(new Now(nr, nc));
                    }
                }
            }
        }

        return cnt;
    }

    public static boolean isIn(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < N;
    }
}
