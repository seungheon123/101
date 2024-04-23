package com.example.demo.Day_79;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n];
        int[] count = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            dp[i] = Integer.parseInt(st.nextToken());
        }

        int res = 0;

        count[0] = 1;
        for(int i = 1; i<n; i++){
            for(int j = 0; j<i; j++){
                if(dp[i] > dp[j]) {
                    count[i] = Math.max(count[i],count[j]+1);
                }
            }
            res = Math.max(res,count[i]);
        }
        //System.out.print(res);
        System.out.println(Arrays.stream(count).max().getAsInt());
    }
}
