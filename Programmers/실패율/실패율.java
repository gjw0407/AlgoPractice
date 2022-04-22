package Programmers.실패율;

import java.util.*;

// time: 20:07
// 2022.04.22
public class 실패율 {

    public static void main(String[] args) {
        System.out.println(solution(4, new int[]{4,4,4,4,4}));
    }

    static class Rate{
        int idx;
        double rate;

        public Rate(int idx, double rate) {
            this.idx = idx;
            this.rate = rate;
        }
    }

    static public List<Integer> solution(int N, int[] stages) {

        ArrayList<Rate> list = new ArrayList<>();

        for(int i = 1; i <= N; i++){
            int unclear = 0;
            int stage = 0;
            for(int s = 0; s < stages.length; s++){
                if(i <= stages[s]){
                    stage++;
                }
                if(i == stages[s]){
                    unclear++;
                }
            }

            double res = 0;
            if(stage == 0){
                res = 0;
            } else{
                 res = (double) unclear / (double) stage;
            }

            list.add(new Rate(i, res));
        }
        for(int i = 0; i < list.size(); i++){
            System.out.print(list.get(i).idx + " " + list.get(i).rate + " ");
        }
        System.out.println();
        Collections.sort(list, ((o1, o2) -> Double.compare(o2.rate, o1.rate)));
        Collections.sort(list, new Comparator<Rate>() {
            @Override
            public int compare(Rate o1, Rate o2) {
                if(o1.rate == o2.rate){
                    return Double.compare(o2.idx, o1.idx);
                }
                return Double.compare(o2.rate, o1.rate);
            }
        });

        for(int i = 0; i < list.size(); i++){
            System.out.print(list.get(i).idx + " " + list.get(i).rate+ " ");
        }
        System.out.println();
        List<Integer> answer = new ArrayList<>();

        for(int i = 0; i < list.size(); i++){
            answer.add(list.get(i).idx);
        }

        return answer;
    }

}
