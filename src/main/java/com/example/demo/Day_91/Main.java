package com.example.demo.Day_91;


import java.util.*;
public class Main {
    public static String solution(int[] food) {
        String answer = "";
        for(int i = 1; i<food.length; i++){
            String str;
            if(food[i]%2==0){
                str = String.valueOf(i).repeat(food[i]/2);
            } else {
                str = String.valueOf(i).repeat((food[i]-1)/2);
            }
            answer+=str;
        }
        String[] array = answer.split("");
        Arrays.sort(array, Collections.reverseOrder());
        answer+="0";
        for(String s: array){
            answer+=s;
        }
        return answer;
    }
}
