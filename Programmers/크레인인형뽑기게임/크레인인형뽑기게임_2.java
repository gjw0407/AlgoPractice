package Programmers.크레인인형뽑기게임;

import java.util.Stack;

// 2022.04.22
public class 크레인인형뽑기게임_2 {
    static int [][] boards = {{0, 0, 1, 0, 0}, {0, 0, 1, 0, 0}, {0, 2, 1, 0, 0}, {0, 2, 1, 0, 0}, {0, 2, 1, 0, 0}};
    static int [] move = {1, 2, 3, 3, 2, 3, 1};

    static Stack<Integer> st = new Stack<>();

    public static void main(String[] args) {
        System.out.println(solution(boards, move));
    }

    static public int solution(int[][] board, int[] moves) {
        int answer = 0;

//        for(int r = 0; r < map.length; r++){
//            for(int c = 0 ;c < map[0].length; c++){
//                System.out.print(map[r][c]);
//            }
//            System.out.println();
//        }

        if(moves.length == 1){
            return 0;
        }

        for(int r= 0; r < board.length; r++){
            if(board[r][moves[0] - 1] > 0){
                st.push(board[r][moves[0] - 1]);
                board[r][moves[0] - 1] = 0;
                break;
            }
        }
//
//        for(int r = 0; r < map.length; r++){
//            for(int c = 0 ;c < map[0].length; c++){
//                System.out.print(map[r][c]);
//            }
//            System.out.println();
//        }

//        System.out.println(st.peek());

        for(int i = 1; i < moves.length; i++){
            System.out.println(i + " i ");
            for(int r = 0; r < board.length; r++){
                if(board[r][moves[i] - 1] > 0){
                    System.out.println(board[r][moves[i] - 1] + " map");
                    if(!st.empty()){
                        if(st.peek() == board[r][moves[i]-1]){
                            System.out.println(board[r][moves[i]-1] + " board");
                            System.out.println("in " + st.peek());
                            answer++;
                            System.out.println(st + " st");
                            st.pop();
                        } else{
                            st.push(board[r][moves[i]-1]);
                        }
                    } else{
                        st.push(board[r][moves[i]-1]);
                    }
                    board[r][moves[i] - 1] = 0;
                    break;
                }
            }

        }

        System.out.println(st);

        return answer * 2;
    }
}
