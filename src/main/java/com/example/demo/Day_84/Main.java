package com.example.demo.Day_84;

import java.util.*;
class Main {
    public String solution(String s) {
        String answer = "";
        int len = s.length();
        String[] str = s.split(" ");
        for(int i = 0; i<str.length; i++){
            String now = str[i];

            if(now.isEmpty()){
                answer +=" ";
            } else{
                answer+=now.substring(0,1).toUpperCase();
                answer+=now.substring(1).toLowerCase();
                answer+=" ";
            }
        }

        if(s.substring(s.length()-1).equals(" ")){
            return answer;
        }

        return answer.substring(0,answer.length()-1);
    }
}
