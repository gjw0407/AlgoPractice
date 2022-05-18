package programmers.lv2.캐시;

import java.util.ArrayList;
import java.util.List;

// time: 12:22
// 2022.05.01
public class 캐시 {
    public static void main(String[] args) {
        System.out.println(solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
        System.out.println(solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}));
        System.out.println(solution(2, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));
        System.out.println(solution(5, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));
        System.out.println(solution(2, new String[]{"Jeju", "Pangyo", "NewYork", "newyork"}));
        System.out.println(solution(0, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
    }

    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;

        List<String> list = new ArrayList<>();

        for(int i = 0; i < cities.length; i++){
            cities[i] = cities[i].toLowerCase();
        }

        if(cacheSize == 0){
            return cities.length * 5;
        }

        for(int i = 0; i < cities.length; i++){
            if(list.size() == cacheSize){
                if(list.contains(cities[i])){
                    answer += 1;
                    list.remove(cities[i]);
                    list.add(cities[i]);
                } else{
                    list.remove(0);
                    list.add(cities[i]);
                    answer += 5;
                }
            } else {
                if(list.contains(cities[i])){
                    answer += 1;
                    list.remove(cities[i]);
                    list.add(cities[i]);
                } else {
                    list.add(cities[i]);
                    answer += 5;
                }
            }

        }

        return answer;
    }
}
