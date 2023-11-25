package com.example.demo.Day14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int X = Integer.parseInt(br.readLine());
        int n = 0;
        int cnt = 0;
        int sum = 0;
        int num;
        int mod;
        while(cnt<X){
            n++;
            cnt+=n;
        }
        for(int i = 0; i<n; i++){
            sum+=i;
        }
        int seq = X - sum-1;
        if(n%2==0){
            num = 1;
            mod = n;

            for(int i = 0; i<seq; ++i){
                num++;
                mod--;
            }
        }else{
            num = n;
            mod = 1;
            for(int i = 0; i<seq; i++){
                num--;
                mod++;
            }
        }
        sb.append(num).append("/").append(mod);
        System.out.println(sb);

    }
}
