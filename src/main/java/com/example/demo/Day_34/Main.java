package com.example.demo.Day_34;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int res = 0;
        if(N==1){
            res = 1;
        }else if(N==2){
            res = Math.min((M+1)/2,4);
        }else{
            if(M<7){
                res = Math.min(M,4);
            }else{
                res = M-2;
            }
        }
        System.out.println(res);
    }
}
