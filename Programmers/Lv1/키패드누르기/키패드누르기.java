package Programmers.Lv1.키패드누르기;

// time: 20:36
// 2022.04.18
public class 키패드누르기 {
    static int numbers[] = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};

    public static void main(String[] args) {
        solution(numbers,"right");
    }

    static public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();

        int left = 10;
        int right = 12;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                sb.append("L");
                left = numbers[i];
            } else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                sb.append("R");
                right = numbers[i];
            } else {
                int tempL = findDistance(left, numbers[i]);
                int tempR = findDistance(right, numbers[i]);

                if (tempL > tempR) {
                    sb.append("R");
                    right = numbers[i];
                } else if (tempL < tempR) {
                    sb.append("L");
                    left = numbers[i];
                } else {
                    if (hand.equals("right")) {
                        sb.append("R");
                        right = numbers[i];
                    } else {
                        sb.append("L");
                        left = numbers[i];
                    }
                }
            }
        }

        return sb.toString();
    }

    static public int findDistance(int finger, int number){

        if(number == 0){
            number = 11;
        }

        if(finger == 0){
            finger = 11;
        }

        int fingerX = (finger - 1) / 3;
        int fingerY = (finger - 1) % 3;

        int numberX = (number - 1) / 3;
        int numberY = (number - 1) % 3;

        return Math.abs(fingerX - numberX) + Math.abs(fingerY - numberY);
    }
}
