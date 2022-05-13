import java.util.HashMap;
import java.util.Map;

public class 방금그곡2 {

    public static void main(String[] args) {
        System.out
                .println(solution("ABCDEFG", new String[] { "12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF" }));
    }

    public static String solution(String m, String[] musicinfos) {
        String answer = "";

        int maxTime = 0;
        for (int i = 0; i < m.length(); i++) {
            m = m.replace("A#", "a");
            m = m.replace("C#", "c");
            m = m.replace("D#", "d");
            m = m.replace("F#", "f");
            m = m.replace("G#", "g");
            m = m.replace("E#", "e");
        }

        for (int i = 0; i < musicinfos.length; i++) {
            String[] temp = musicinfos[i].split(",");
            int time = calcTime(temp[1]) - calcTime(temp[0]);

            temp[3] = temp[3].replace("A#", "a");
            temp[3] = temp[3].replace("C#", "c");
            temp[3] = temp[3].replace("D#", "d");
            temp[3] = temp[3].replace("F#", "f");
            temp[3] = temp[3].replace("G#", "g");
            temp[3] = temp[3].replace("E#", "e");

            String newMusic = "";
            for (int j = 0; j < time; j++) {
                newMusic += temp[3].charAt(j % temp[3].length());
            }

            if (newMusic.contains(m)) {
                if (maxTime < newMusic.length()) {
                    maxTime = newMusic.length();
                    answer = temp[2];
                }
            }

        }

        return answer;
    }

    public static int calcTime(String time) {
        String[] tempT = time.split(":");

        int hour = Integer.parseInt(tempT[0]);
        int min = Integer.parseInt(tempT[1]);

        return hour * 60 + min;
    }
}
