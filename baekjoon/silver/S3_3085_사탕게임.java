package baekjoon.silver;

import java.util.Arrays;
import java.util.Scanner;

public class S3_3085_사탕게임 {
    static char[][] map;
    static int N;
    static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        map = new char[N][N];
        for (int r = 0; r < N; r++) {
            String st = sc.next();
            for (int c = 0; c < N; c++) {
                map[r][c] = st.charAt(c);
            }
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                change(r, c, map[r][c]);
            }
        }

    }

    public static void change(int r, int c, char now) {
        char[][] newMap = new char[N][N];

        for (int d = 0; d < dirs.length; d++) {
            int nr = r + dirs[d][0];
            int nc = c + dirs[d][1];

            if (isIn(nr, nc)) {
                if (map[r][c] != map[nr][nc]) {
                    newMap = map;
                    newMap[r][c] = map[nr][nc];
                    newMap[nr][nc] = map[r][c];
                    find(newMap);
                }
            }
        }
    }

    public static boolean isIn(int nr, int nc) {
        return 0 <= nr && nr < N && 0 <= nc && nc < N;
    }

    public static void find(char[][] newMap) {

        for (int r = 0; r < N; r++) {
            int cntC = 0;
            int cntP = 0;
            int cntZ = 0;
            int cntY = 0;
            for (int c = 0; c < N; c++) {
                if (newMap[r][c] == 'C') {
                    while (true) {
                        if (newMap[r][c] != 'C' || c < N) {
                            break;
                        }
                        cntC++;
                        c++;
                    }
                } else if (newMap[r][c] == 'P') {
                    while (true) {
                        if (newMap[r][c] != 'P' || c < N) {
                            break;
                        }
                        cntP++;
                        c++;
                    }
                } else if (newMap[r][c] == 'Z') {
                    while (true) {
                        if (newMap[r][c] != 'Z' || c < N) {
                            break;
                        }
                        cntZ++;
                        c++;
                    }
                } else if (newMap[r][c] == 'Y') {
                    while (true) {
                        if (newMap[r][c] != 'Y' || c < N) {
                            break;
                        }
                        cntY++;
                        c++;
                    }
                }
            }


        }
    }
}
