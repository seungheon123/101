package com.example.demo.Day_66;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static int n;
    public static int[] arr;
    public static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        for(int i =0; i<n; i++){
            switch (i) {
                case 0:
                    dp[i] = arr[i];
                    break;
                case 1:
                    dp[i] = dp[i-1] + arr[i];
                    break;
                case 2:
                    dp[i] = Math.max(dp[i-2],arr[i-1]) + arr[i];
                    break;
                case 3:
                    dp[i] = Math.max(dp[i-2], dp[i-3]+arr[i-1]) + arr[i];
                    break;
                default:
                    dp[i] = Math.max(dp[i-4]+arr[i-1],Math.max(dp[i-2],dp[i-3]+arr[i-1])) + arr[i];
                    break;
            }
        }
        Arrays.sort(dp);
        System.out.println(dp[n-1]);
    }
}
