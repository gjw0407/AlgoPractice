package Programmers.Lv2.주차요금계산;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// time: 37:32
// 2022.05.03
public class 주차요금계산 {

    static HashMap<String, Integer> money;
    static HashMap<String, String> map;

    public static void main(String[] args) {
        System.out.println(solution(new int[]{180, 5000, 10, 600}, new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"}));
    }

    public static List<Integer> solution(int[] fees, String[] records) {
        List<Integer> answer = new ArrayList<>();

        List<String> time = new ArrayList<>();
        List<String> car = new ArrayList<>();
        List<String> inout = new ArrayList<>();
        map = new HashMap<>();
        money = new HashMap<>();

        for(int i = 0; i < records.length; i++){
            String [] temp = records[i].split(" ");

            if(!map.containsKey(temp[1])){
                map.put(temp[1], temp[0]);
                System.out.println(map.get(temp[1]) + "not Contain car" + temp[1]);
            } else {
                String inTime = map.get(temp[1]);
                System.out.println("in time " + inTime + " outtime " + temp[0] + " car " + temp[1]);
                calc(inTime, temp[0], fees, temp[1]);
                map.remove(temp[1]);
            }
        }

        for(int i = 0; i < map.size(); i++){
            System.out.println(money);
        }

        for(int i = 0; i < car.size(); i++){
            System.out.print(car.get(i) +" ");
        }

        return answer;
    }

    public static void calc(String inTime, String outTime, int[] fees, String car){

        String inTimes[] = inTime.split(":");
        String outTimes[] = outTime.split(":");

        int hour = 0;
        int min = 0;
        if(Integer.parseInt(outTimes[1]) < Integer.parseInt(inTimes[1])){
            min = 60 +  Integer.parseInt(outTimes[1]) - Integer.parseInt(inTimes[1]) + (Integer.parseInt(outTimes[0]) - Integer.parseInt(inTimes[0]) - 1) * 60;
//            hour = Integer.parseInt(inTimes[0]) - Integer.parseInt(outTimes[0]) - 1;
        } else {
            min = Integer.parseInt(outTimes[1]) - Integer.parseInt(inTimes[1]) + (Integer.parseInt(outTimes[0]) - Integer.parseInt(inTimes[0])) * 60;
            hour = Integer.parseInt(inTimes[0]) - Integer.parseInt(outTimes[0]) ;
        }
//        System.out.println(inTime + outTime + car);
        System.out.println(min);
        if(min < fees[0]){
            System.out.println("inmin");
            System.out.println(car + fees[1]);
            money.put(car, fees[1]);
        } else {
            System.out.println("inovjewiaofjoiweajgo");
            int cnt = fees[1] + ((min - fees[0]) / fees[2]) * fees[3];
            System.out.println(car + cnt);
            money.put(car, cnt);
        }

    }
}
