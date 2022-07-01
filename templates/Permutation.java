package templates;

import java.util.Arrays;

public class Permutation {
    static char[] src = {'a', 'b', 'c', 'd'};

    public static void main(String[] args) {
        permutation(3, new boolean[4], new char[3]);
    }

    public static void permutation(int r, boolean[] visited, char[] temp) {
        if (r == 0) {
            System.out.println(Arrays.toString(temp));
            return;
        }

        for (int i = 0; i < src.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                temp[r - 1] = src[i];
                permutation(r - 1, visited, temp);
                visited[i] = false;
            }
        }

    }
}
