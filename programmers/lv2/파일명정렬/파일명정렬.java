package programmers.lv2.파일명정렬;

import java.util.*;

// time: 33:51
// 2022.05.22
public class 파일명정렬 {
    public static void main(String[] args) {
//        System.out.println(solution(new String[]{"img12.png"}));
        System.out.println(solution(new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"}));
//        System.out.println(solution(new String[]{"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"}));
    }

    public static String[] solution(String[] files) {
        String[] answer = {};

        List<String> listHead = new ArrayList<>();
        List<Integer> listNum = new ArrayList<>();
        HashMap<String, Integer> mapHead = new HashMap<>();
        HashMap<String, Integer> mapNum = new HashMap<>();
        for (int i = 0; i < files.length; i++) {
            String head = "";
            String num = "";

            int numStart = 0;
            for (int j = 0; j < files[i].length(); j++) {
                if ('0' <= files[i].charAt(j) && files[i].charAt(j) <= '9') {
                    numStart++;
                }
            }

            for (int j = 0; j < files[i].length(); j++) {
                if ('0' <= files[i].charAt(j) && files[i].charAt(j) <= '9') {
                    num += String.valueOf(files[i].charAt(j));
                } else {
                    head += String.valueOf(files[i].charAt(j));
                    if (head.length() - 1 + numStart < j + 1) {
                        break;
                    }
                }
            }

            head = head.substring(0, head.length() - 1);
            mapHead.put(head, i);
            mapNum.put(num, i);
            listHead.add(head.toLowerCase());
            listNum.add(Integer.parseInt(num));
            System.out.println(head);
            System.out.println(num);
        }

        Collections.sort(listHead);
        Collections.sort(listNum);

        return answer;
    }
}
