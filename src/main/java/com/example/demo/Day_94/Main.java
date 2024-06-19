package com.example.demo.Day_94;
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        String[] survey = {"RJ","RT","CJ","CF","TF","TN","RF","RN","CJ","CF"};
        int[] choices = {3,3,4,4,4,4,3,3,4,4};
        System.out.println(solution(survey,choices));
    }
    public static String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0; i<choices.length; i++){
            int value = choices[i];
            if(value<4){
                int x = 4 - value;
                char ch = survey[i].charAt(0);
                map.put(ch, map.getOrDefault(ch,0)+x);
            }else if(value>4){
                int x = value % 4;
                char ch = survey[i].charAt(1);
                map.put(ch, map.getOrDefault(ch,0)+x);
            }
        }

        answer.append(map.getOrDefault('R',0)>=map.getOrDefault('T',0)?'R':'T');
        answer.append(map.getOrDefault('C',0)>=map.getOrDefault('F',0)?'C':'F');
        answer.append(map.getOrDefault('J',0)>=map.getOrDefault('M',0)?'J':'M');
        answer.append(map.getOrDefault('A',0)>=map.getOrDefault('N',0)?'A':'N');


        return answer.toString();
    }

}
