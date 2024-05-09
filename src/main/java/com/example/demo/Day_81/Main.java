package com.example.demo.Day_81;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static StringBuilder max = new StringBuilder();
    public static StringBuilder min = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();

        findMax(num);
        findMin(num);
        System.out.println(max);
        System.out.println(min);


    }

    public static void findMax(String num){
        boolean flag = false;
        int cnt = 0;
        for (int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);
            if(!flag && ch=='K') max.append('5');
            if(ch=='M'){
                cnt++;
                flag = true;
            } else if (flag && ch == 'K') {
                max.append("5").append("0".repeat(cnt));
                cnt = 0;
                flag = false;
            }
        }
        if(cnt!=0) max.append("1".repeat(cnt));
    }

    public static void findMin(String num){
        boolean flag = false;
        int cnt = 0;
        for (int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);
            if(!flag && ch=='K') min.append('5');
            if (ch == 'M') {
                cnt++;
                flag = true;
            } else if (flag && ch == 'K') {
                min.append("1").append("0".repeat(cnt - 1)).append("5");
                cnt=0;
                flag = false;
            }
        }
        if (cnt != 0) {
            min.append("1").append("0".repeat(cnt-1));
        }
    }
}
