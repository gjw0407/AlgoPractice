package Programmers.Lv2.프렌즈4블록;

import java.util.ArrayList;
import java.util.List;

public class 프렌즈4블록3 {
    static char[][] map;
    static int answer;

    public static void main(String[] args) {
        System.out.println(solution(4,5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"}));
        System.out.println(solution(6,6, new String[]{"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"}));
    }

    private static int solution(int m, int n, String[] board) {
        answer = 0;

        map = new char[m][n];
        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                map[r][c] = board[r].charAt(c);
            }
        }

        while(update(m,n,map));

        return answer;

    }

    public static boolean update(int m, int n, char[][] map){
        boolean visited[][] = new boolean[m][n];
        int cnt = 0;

        for(int r = 0; r < m - 1; r++){
            for(int c = 0; c < n - 1; c++){
                if (map[r][c] != '0' && check(r,c)){
                    visited[r][c] = visited[r+1][c] = visited[r][c+1] = visited[r + 1][c+1] = true;
                }
            }
        }

        for(int c = 0; c < n; c++){
            List<Character> list = new ArrayList<>();
            for(int r = m-1; r>= 0; r--){
                if(!visited[r][c]){
                    list.add(map[r][c]);
                }
            }

            for(int r= m-1, k= 0; r >= 0; r--, k++){
                if(list.size() > k){
                    map[r][c] = list.get(k);
                } else{
                    map[r][c] = '0';
                }
            }
        }

        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                if (visited[r][c]) {
                    cnt++;
                }
            }
        }

        if(cnt == 0){
            return false;
        } else {
            answer += cnt;
            return true;
        }
    }

    private static boolean check(int r, int c){
        char now = map[r][c];

        if(map[r][c + 1] == now && map[r + 1][c + 1] == now && map[r + 1][c] == now){
            return true;
        }
        return false;
    }

}
