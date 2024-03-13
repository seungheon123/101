package com.example.demo.Day_56;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String board = br.readLine();
        int count = 0;
        for(int i = 0 ; i< board.length(); i++){
            if(board.charAt(i)=='.'){
                make(count);
                sb.append('.');
                count = 0;
            } else count++;
        }
        if(count>0) make(count);
        System.out.println(sb);
    }

    public static void make(int num) {
        if(num%4==0){
            sb.append("AAAA".repeat(Math.max(0, num / 4)));
        }
        else if((num-2)%4==0){
            sb.append("AAAA".repeat(Math.max(0, (num - 2) / 4)));
            sb.append("BB");
        }
        else if(num%2==0){
            sb.append("BB".repeat(Math.max(0, num/2)));
        }
        else {
            System.out.println(-1);
            System.exit(0);
        }

    }
}
