package Programmers.Lv1.비밀지도;

// time: 30:05
// 2022.04.23
public class 비밀지도 {

    public static void main(String[] args) {
        System.out.println(solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28}).toString());
    }
    static public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        int[][] map1 = new int[n][n];
        int[][] map2 = new int[n][n];

        for(int i = 0; i < n; i++){
           while(true){
                for(int c = n - 1; c >= 0; c--){
                    map1[i][c] = arr1[i] % 2;
                    arr1[i] = arr1[i] / 2;

                    map2[i][c] = arr2[i] % 2;
                    arr2[i] = arr2[i] / 2;
                }
                break;
            }
        }

        for(int r = 0; r < n; r++){
            StringBuilder sb = new StringBuilder();
            for(int c = 0; c < n; c++){
                if(map1[r][c] + map2[r][c] == 0){
                    sb.append(" ");
                } else {
                    sb.append("#");
                }
            }
            answer[r] = sb.toString();
        }

        return answer;
    }
}
