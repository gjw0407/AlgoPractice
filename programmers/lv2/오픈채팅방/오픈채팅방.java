package programmers.lv2.오픈채팅방;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 오픈채팅방 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"}));
    }

    public static List<String> solution(String[] record) {
        List<String> answer = new ArrayList<>();

        Map<String, String> map = new HashMap<>();
        Map<String, String> tempMap = new HashMap<>();
        List<String> tempM = new ArrayList<>();
        for (int i = 0; i < record.length; i++) {
            String[] temp = record[i].split(" ");

            if(temp[0].equals("Enter")){
                tempMap.put(temp[1], "님이 들어왔습니다.");
                tempM.add(temp[1] + " 님이 돌아왔습니다.");
                map.put(temp[1],temp[2]);
            } else if(temp[0].equals("Leave")){
                System.out.println("leave");
                tempMap.put(temp[1], "님이 나갔습니다.");
                tempM.add(temp[1] + " 님이 나갔습니다.");
//                map.put(temp[1],temp[2]);
            } else {
                map.put(temp[1],temp[2]);
            }

        }

        System.out.println(map);
        System.out.println(tempMap);
        System.out.println(tempM);

        return answer;
    }
}
