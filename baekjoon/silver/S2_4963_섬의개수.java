package baekjoon.silver;

import java.util.Scanner;

public class S2_4963_섬의개수 {
    static int w, h;
    static int map[][];
    static int dirs[][] = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    static boolean visited[][];
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            w = sc.nextInt();
            h = sc.nextInt();

            if (w == 0 && h == 0) {
                break;
            }

            answer = 0;
            visited = new boolean[h][w];
            map = new int[h][w];
            for (int r = 0; r < h; r++) {
                for (int c = 0; c < w; c++) {
                    map[r][c] = sc.nextInt();
                }
            }

            for (int r = 0; r < h; r++) {
                for (int c = 0; c < w; c++) {
                    if (map[r][c] == 1 && !visited[r][c]) {
                        answer += dfs(r, c);
                    }
                }
            }


            System.out.println(answer);

        }

    }

    static int dfs(int r, int c) {

        visited[r][c] = true;

        for (int d = 0; d < dirs.length; d++) {
            int nr = r + dirs[d][0];
            int nc = c + dirs[d][1];

            if (isIn(nr, nc)) {
                if (map[nr][nc] == 1 && !visited[nr][nc]) {
                    dfs(nr, nc);
                }
            }
        }
        return 1;
    }

    static boolean isIn(int r, int c) {
        return 0 <= r && r < h && 0 <= c && c < w;
    }
}

