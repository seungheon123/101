package com.example.demo.Day_63;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int N;
    public static int count = 0;
    public static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i<=N; i++){
            int min = Integer.MAX_VALUE;
            for(int j =1; j*j<=i; j++){
                min = Math.min(min, dp[i-(j*j)]);
            }
            dp[i] = min+1;
        }
        System.out.println(dp[N]);
    }

}
