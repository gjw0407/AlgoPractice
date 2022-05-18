package programmers.lv2.프렌즈4블록;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// time: 47:02
// 2022.05.01
public class 프렌즈4블록 {
    static char[][] map;
    static int[][] dirs = {{1,1},{1,-1},{-1,1},{-1,-1}};
    static List<Now> list = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(solution(4,5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"}));
    }

    private static int solution(int m, int n, String[] board) {
        int answer = 0;

        map = new char[m][n];
        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                map[r][c] = board[r].charAt(c);
            }
        }

        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                System.out.print(map[r][c]);
            }
            System.out.println();
        }

        while(true){
//            if(n == 0){
//                break;
//            }

            boolean visited[][] = new boolean[m][n];
            for(int r = 0; r < m; r++){
                for(int c = 0; c < n; c++){
                    if(!visited[r][c] && map[r][c] != ' '){
                        visited[r][c] = true;
                        bfs(r, c, visited, m, n);
                    }
                }
            }

            int listSize = list.size();
            for(int i = 0; i < list.size(); i++){
                map[list.get(i).r][list.get(i).c] = ' ';
            }

            for(int i = 0; i < list.size(); i++){
                System.out.println(list.get(i).r + " " + list.get(i).c);
            }

            System.out.println();
            for(int r = 0; r < m; r++){
                for(int c = 0; c < n; c++){
                    System.out.print(map[r][c]);
                }
                System.out.println();
            }

            List<Now> l = new ArrayList<>();
            for(int i = 0; i < list.size(); i++){
                if(list.remove(list.get(i))){
                    l.add(list.get(i));
                }
            }

            System.out.println(listSize + " " + l.size());
            answer += (listSize - l.size());

            break;

        }

        return answer;
    }

    private static class Now{
        int r, c;

        public Now(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private static void bfs(int r, int c, boolean[][] visited, int m, int n){
        Queue<Now> q = new LinkedList<>();
        q.offer(new Now(r,c));
        visited[r][c] = true;

        while(!q.isEmpty()){
            Now now = q.poll();

            for(int d = 0; d < dirs.length; d++){
                int nr = now.r + dirs[d][0];
                int nc = now.c + dirs[d][1];

                if(isIn(m,n,nr,nc) && map[nr][nc] != ' '){
                    if(map[r][c] == map[nr][nc]){
                        if(d == 0){
                            if(map[r][c] == map[r + 1][c] && map[r][c] == map[r][c + 1]){
                                visited[nr][nc] = true;
                                visited[r + 1][c] = true;
                                visited[r][c + 1] = true;
                                list.add(new Now(nr, nc));
                                list.add(new Now(r + 1, c));
                                list.add(new Now(r, c + 1));
                                q.offer(new Now(nr,nc));
                            }
                        } else if(d == 1){
                            if(map[r][c] == map[r + 1][c] && map[r][c] == map[r][c - 1]){
                                visited[nr][nc] = true;
                                visited[r + 1][c] = true;
                                visited[r][c - 1] = true;
                                list.add(new Now(nr, nc));
                                list.add(new Now(r + 1, c));
                                list.add(new Now(r, c - 1));
                                q.offer(new Now(nr,nc));
                            }
                        } else if(d == 2){
                            if(map[r][c] == map[r - 1][c] && map[r][c] == map[r][c + 1]){
                                visited[nr][nc] = true;
                                visited[r - 1][c] = true;
                                visited[r][c + 1] = true;
                                list.add(new Now(nr, nc));
                                list.add(new Now(r - 1, c));
                                list.add(new Now(r, c + 1));
                                q.offer(new Now(nr,nc));
                            }
                        } else {
                            if(map[r][c] == map[r - 1][c] && map[r][c] == map[r][c - 1]){
                                visited[nr][nc] = true;
                                visited[r - 1][c] = true;
                                visited[r][c - 1] = true;
                                list.add(new Now(nr, nc));
                                list.add(new Now(r - 1, c));
                                list.add(new Now(r, c - 1));
                                q.offer(new Now(nr,nc));
                            }
                        }
                    }
                }
            }
        }
    }

    private static boolean isIn(int r, int c, int nr, int nc){
        return 0 <= nr && nr < r && 0 <= nc && nc < c;
    }
}
