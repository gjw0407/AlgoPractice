package templates;

import java.util.Arrays;

public class Combination {
    static char[] src = {'a', 'b', 'c'};

    public static void main(String[] args) {
        combination(2, 0, new char[2]);
    }

    private static void combination(int r, int start, char[] temp) {
        if (r == 0) {
            System.out.println(Arrays.toString(temp));
            return;
        }

        for (int i = start; i < src.length; i++) {
            temp[r - 1] = src[i];
            combination(r - 1, i + 1, temp);
        }
    }

}
