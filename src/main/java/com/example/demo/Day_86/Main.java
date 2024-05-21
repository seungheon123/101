package com.example.demo.Day_86;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] answer = new int[2];
        int count = 0;
        int zeroCount = 0;
        while(s.length()>1){
            int one = 0;
            for(int i = 0; i<s.length(); i++){
                if(s.charAt(i)=='0') zeroCount++;
                else one++;
            }
            s = Integer.toBinaryString(one);
            count++;
        }
        answer[0] = count;
        answer[1] = zeroCount;
    }
}
