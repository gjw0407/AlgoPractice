package programmers.lv2.카카오프렌즈컬러링북;

import java.util.LinkedList;
import java.util.Queue;

public class 카카오프렌즈컬러링북 {
    static int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
    static Queue<Now> q;
    static int map[][];
    static int cnt;

    public static void main(String[] args) {

    }

    static class Now{
        int r, c;

        public Now(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        map = new int[m][n];
        map = picture;
        for(int r = 0; r < picture.length; r++){
            for(int c = 0; c < picture[0].length; c++){
                if(picture[r][c] > 0){
                    cnt = 1;
                    q = new LinkedList<>();
                    numberOfArea += bfs(r, c, map, picture[r][c]);
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea,cnt);
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;

        return new int[]{numberOfArea, maxSizeOfOneArea};
    }

    static public int bfs(int r, int c, int[][] map, int val){

        int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
        q.add(new Now(r,c));
        map[r][c] = -1;

        while(!q.isEmpty()){
            Now now = q.poll();

            for(int d = 0; d < dirs.length; d++){
                int nr = now.r + dirs[d][0];
                int nc = now.c + dirs[d][1];

                if(isIn(map.length,map[0].length,nr,nc)){
                    if(map[nr][nc] > 0  && map[nr][nc] == val){
                        q.add(new Now(nr,nc));
                        map[nr][nc] = -1;
                        cnt++;
                    }
                }
            }
        }

        return 1;
    }

    static public boolean isIn(int r, int c, int nr, int nc){
        return 0 <= nr && nr < r && 0 <= nc && nc < c;
    }
}
