package com.example.demo.Day_89;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] score = {0, 300, 40, 300, 20, 70, 150, 50, 500, 1000};
        int[] solution = solution(3, score);
    }

    public static int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i<score.length; i++){
            list.add(score[i]);
            if(list.size()>k){
                list.remove(Collections.min(list));
            }
            answer[i] = Collections.min(list);
        }
        return answer;
    }
}
