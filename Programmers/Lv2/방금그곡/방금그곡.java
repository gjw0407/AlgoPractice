import java.util.HashMap;
import java.util.Map;

public class 방금그곡 {

    public static void main(String[] args) {
        System.out
                .println(solution("ABCDEFG", new String[] { "12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF" }));
    }

    public static String solution(String m, String[] musicinfos) {
        String answer = "";

        Map<String, Integer> ans = new HashMap<>();
        for (int i = 0; i < musicinfos.length; i++) {
            String[] temp = musicinfos[i].split(",");
            int time = check(temp[1]) - check(temp[0]);
            int musicS = 0;

            for (int j = 0; j < temp[3].length(); j++) {
                if (temp[3].charAt(j) == '#') {
                    musicS++;
                }
            }

            String newMusic = "";
            if (musicS > time) {
                newMusic = "";

            } else if (musicS < time) {
                newMusic += temp[3].substring(0, musicS);

                if (newMusic.contains(m)) {
                    ans.put(temp[3], musicS);
                }

            } else {

            }

        }

        return answer;
    }

    public static int check(String time) {
        int temp = 0;

        String[] tempT = time.split(":");

        int hour = Integer.parseInt(tempT[0]);
        int min = Integer.parseInt(tempT[1]);

        return hour * 60 + min;
    }
}
