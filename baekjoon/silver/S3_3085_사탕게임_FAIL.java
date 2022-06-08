package baekjoon.silver;

import java.util.Scanner;

public class S3_3085_사탕게임_FAIL {
    static char[][] map;
    static int N;
    static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int max = 0;

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
                change(r, c);
            }
        }

        System.out.println(max);

    }

    public static void change(int r, int c) {

        for (int d = 0; d < dirs.length; d++) {
            int nr = r + dirs[d][0];
            int nc = c + dirs[d][1];

            if (isIn(nr, nc)) {
                if (map[r][c] != map[nr][nc]) {
                    char[][] newMap = new char[N][N];
                    for (int i = 0; i < N; i++) {
                        for (int j = 0; j < N; j++) {
                            newMap[i][j] = map[i][j];
                        }
                    }
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
                        if (c == N || newMap[r][c] != 'C') {
                            break;
                        }
                        cntC++;
                        c++;
                    }
                    max = Math.max(max, cntC);
                    cntC = 0;
                } else if (newMap[r][c] == 'P') {
                    while (true) {
                        if (c == N || newMap[r][c] != 'P') {
                            break;
                        }
                        cntP++;
                        c++;
                    }
                    max = Math.max(max, cntP);
                    cntP = 0;
                } else if (newMap[r][c] == 'Z') {
                    while (true) {
                        if (c == N || newMap[r][c] != 'Z') {
                            break;
                        }
                        cntZ++;
                        c++;
                    }
                    max = Math.max(max, cntZ);
                    cntZ = 0;
                } else if (newMap[r][c] == 'Y') {
                    while (true) {
                        if (c == N || newMap[r][c] != 'Y') {
                            break;
                        }
                        cntY++;
                        c++;
                    }
                    max = Math.max(max, cntY);
                    cntY = 0;
                }
            }
        }

        for (int c = 0; c < N; c++) {
            int cntC = 0;
            int cntP = 0;
            int cntZ = 0;
            int cntY = 0;
            for (int r = 0; r < N; r++) {
                if (newMap[r][c] == 'C') {
                    while (true) {
                        if (r == N || newMap[r][c] != 'C') {
                            break;
                        }
                        cntC++;
                        r++;
                    }
                    max = Math.max(max, cntC);
                    cntC = 0;
                } else if (newMap[r][c] == 'P') {
                    while (true) {
                        if (r == N || newMap[r][c] != 'P') {
                            break;
                        }
                        cntP++;
                        r++;
                    }
                    max = Math.max(max, cntP);
                    cntP = 0;
                } else if (newMap[r][c] == 'Z') {
                    while (true) {
                        if (r == N || newMap[r][c] != 'Z') {
                            break;
                        }
                        cntZ++;
                        r++;
                    }
                    max = Math.max(max, cntZ);
                    cntZ = 0;
                } else if (newMap[r][c] == 'Y') {
                    while (true) {
                        if (r == N || newMap[r][c] != 'Y') {
                            break;
                        }
                        cntY++;
                        r++;
                    }
                    max = Math.max(max, cntY);
                    cntY = 0;
                }
            }
        }
    }
}
