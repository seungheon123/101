package com.example.demo.Day_68;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static double[] arr;
    public static double[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new double[N];
        dp = new double[N];
        for(int i = 0; i<N; i++){
            arr[i] = Double.parseDouble(br.readLine());
        }
        dp[0] = arr[0];
        double max = Double.MIN_VALUE;
        for(int i = 1; i<N; i++){
            dp[i] = Math.max(Math.max(dp[i-1]*arr[i],arr[i-1]*arr[i]),arr[i]);
            max = Math.max(max, dp[i]);
        }
        System.out.printf("%.3f", max);
    }
}
