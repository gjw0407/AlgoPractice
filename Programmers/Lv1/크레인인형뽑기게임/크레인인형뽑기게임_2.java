package Programmers.Lv1.크레인인형뽑기게임;

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

        for(int i = 1; i < moves.length; i++){
            for(int r = 0; r < board.length; r++){
                if(board[r][moves[i] - 1] > 0){
                    if(!st.empty()){
                        if(st.peek() == board[r][moves[i]-1]){
                            answer++;
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

        return answer * 2;
    }
}
