package programmers.lv2.주차요금계산;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

// time: 37:32
// 2022.05.03
public class 주차요금계산2 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{180, 5000, 10, 600}, new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"}));
    }

    public static int[] solution(int[] fees, String[] records) {

        List<String> cars = new ArrayList<>();
        HashMap<String, Integer>times = new HashMap<>();
        HashMap<String, Integer>parking = new HashMap<>();

        for(int i = 0; i < records.length; i++){
            String[] rc = records[i].split(" ");
            int time = toMin(rc[0]);
            String car = rc[1];

            // 새로운차 등장
            if(!cars.contains(car)) {
                cars.add(car);
                times.put(car, 0);
            }

            if(parking.containsKey(car)) {
                // 현재 파킹이 되어 있다면 출차다
                times.put( car, times.get(car)+(time-parking.get(car)) );
                parking.remove(car);
            } else {
                // 파킹이 안되어 있다면 입차다.
                parking.put(car, time);
            }
        }

        int[] answer = new int[cars.size()];
        Collections.sort(cars);
        for(int i = 0; i < cars.size(); i++){
            String carr = cars.get(i);
            answer[i] = fees[1];
            int time = times.get(carr) - fees[0];

            if(parking.containsKey(carr)){
                time += (toMin("23:59") - parking.get(carr));
            }
            if(time > 0){
                answer[i] += (Math.ceil(time/(fees[2]*1.0))*fees[3]);
            }

        }

        return answer;
    }

    public static int toMin(String time){
        String times[] = time.split(":");
        return Integer.valueOf(times[0])* 60 + Integer.valueOf(times[1]);
    }
//
//    public static void calc(String inTime, String outTime, int[] fees, String car){
//
//        String inTimes[] = inTime.split(":");
//        String outTimes[] = outTime.split(":");
//
//        int min = 0;
//        if(Integer.parseInt(outTimes[1]) < Integer.parseInt(inTimes[1])){
//            min = 60 +  Integer.parseInt(outTimes[1]) - Integer.parseInt(inTimes[1]) + (Integer.parseInt(outTimes[0]) - Integer.parseInt(inTimes[0]) - 1) * 60;
//        } else {
//            min = Integer.parseInt(outTimes[1]) - Integer.parseInt(inTimes[1]) + (Integer.parseInt(outTimes[0]) - Integer.parseInt(inTimes[0])) * 60;
//        }
//        System.out.println(min);
//        if(min < fees[0]){
//            money.put(car, fees[1]);
//        } else {
//            int cnt = fees[1] + (int) Math.ceil((double) (min - fees[0]) / fees[2]) * fees[3];
//            money.put(car, cnt);
//        }
//
//    }
}
