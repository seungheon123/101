package com.example.demo.Day_88;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] term = {"Z 3", "D 5"};
        String[] privates = {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};
        solution("2020.01.01", term, privates);
    }

    public static int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        String[] st = today.split("\\.");
        int year = Integer.parseInt(st[0]);
        int month = Integer.parseInt(st[1]);
        int day = Integer.parseInt(st[2]);
        int total = (year*12*28) + (month*28) + day;

        HashMap<String, Integer> map = new HashMap<>();

        for(String term: terms){
            String[] t = term.split(" ");
            map.put(t[0],Integer.parseInt(t[1]));
        }

        for(int i = 0; i<privacies.length; i++){
            String privacy = privacies[i];
            String[] str = privacy.split(" ");
            String[] prev = str[0].split("\\.");
            int pYear = Integer.parseInt(prev[0]);
            int pMonth = Integer.parseInt(prev[1]);
            int pDay = Integer.parseInt(prev[2]);
            int pTotal = (pYear*12*28) + (pMonth*28) + pDay;
            String term = str[1];
            int value = map.get(term);
            if(total >= pTotal+(value*28)){
                answer.add(i+1);
            }
        }


        return answer.stream().mapToInt(integer -> integer).toArray();
    }
}