package Programmers.Lv1.크레인인형뽑기게임;

import java.util.Stack;

// time: 35:05
// 2022.04.21
public class 크레인인형뽑기게임 {
    static int [][] boards = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
    static int [] move = {1,5,3,5,1,2,1,4};

    static Stack<Integer> st = new Stack<>();
    static int [][]map;

    public static void main(String[] args) {
        System.out.println(solution(boards, move));
    }

    static public int solution(int[][] board, int[] moves) {
        int answer = 0;

        map = new int[board.length][board[0].length];
        for(int r= 0; r < board.length; r++){
            for(int c= 0; c < board[0].length; c++){
                map[r][c] = board[r][c];
            }
        }

//        for(int r = 0; r < map.length; r++){
//            for(int c = 0 ;c < map[0].length; c++){
//                System.out.print(map[r][c]);
//            }
//            System.out.println();
//        }

        for(int r= 0; r < board.length; r++){
            if(map[r][moves[0] - 1] > 0){
                st.push(map[r][moves[0] - 1]);
                map[r][moves[0] - 1] = 0;
                break;
            }
        }

        for(int r = 0; r < map.length; r++){
            for(int c = 0 ;c < map[0].length; c++){
                System.out.print(map[r][c]);
            }
            System.out.println();
        }

        System.out.println(st.peek());

        for(int i = 1; i < moves.length; i++){
            if(st.peek() == find(moves[i] - 1)){
                System.out.println("in");
                answer++;
                st.pop();
            } else{
                st.push(find(moves[i] - 1));
            }
        }

        System.out.println(st);

        return answer;
    }

    static public int find(int moves){
        for(int r = 0; r < map.length; r++){
            if(map[r][moves] > 0){
                int temp = map[r][moves];
                map[r][moves] = 0;
                return temp;
            }
        }

        return 0;
    }
}
