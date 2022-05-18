package programmers.lv2.거리두기확인하기;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// time: 30:52
// 2022.05.18
public class 거리두기확인하기 {
    public static void main(String[] args) {
        System.out.println(solution(new String[][]{{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}}));
    }

    public static List<Integer> solution(String[][] places) {
        List<Integer> answer = new ArrayList<>();

        for (int r = 0; r < places.length; r++) {
            if (check(places[r])) {
                answer.add(1);
            } else {
                answer.add(0);
            }
        }

        return answer;
    }

    private static boolean manDis(int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2) <= 2;
    }

    private static class Now {
        int r, c;

        public Now(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private static boolean check(String[] place) {
        Queue<Now> list = new LinkedList<>();
        for (int i = 0; i < place.length; i++) {
            for (int j = 0; j < place[i].length(); j++) {
                if (place[i].charAt(j) == 'P') {
                    list.add(new Now(i, j));
                }
            }
        }

        if (list.size() == 0) {
            return true;
        }

        while (!list.isEmpty()) {
            Now n = list.poll();

            for (int i = 0; i < place.length; i++) {
                for (int j = 0; j < place[i].length(); j++) {
                    if (i == n.r && j == n.c) {
                        continue;
                    }

                    if (place[i].charAt(j) == 'P') {
                        if (manDis(i, j, n.r, n.c)) {
                            if (i == n.r) {
                                if (place[i].charAt((j + n.c) / 2) == 'O' || Math.abs(j - n.c) == 1) {
                                    return false;
                                }
                            } else if (j == n.c) {
                                if (place[(i + n.r) / 2].charAt(j) == 'O' || Math.abs(i - n.r) == 1) {
                                    return false;
                                }
                            } else if (i != n.r && j != n.c) {
                                if (place[i].charAt(n.c) == 'O' || place[n.r].charAt(j) == 'O') {
                                    return false;
                                }
                            }
                        }
                    }
                }
            }
        }

        return true;
    }
}
