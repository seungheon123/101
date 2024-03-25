package com.example.demo.Day_67;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int[][] arr;
    public static int[][] dp;
    public static int bigJump = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        dp = new int[N][2];
        for(int i = 0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        bigJump = Integer.parseInt(br.readLine());
        dp[0][0] = 0;
        dp[1][0] = arr[0][0];
        dp[2][0] = Math.min(dp[1][0]+arr[1][0],arr[0][1]);
        for(int i = 3; i<N; i++){
            dp[i][0] = Math.min(dp[i-1][0]+arr[i-1][0], dp[i-2][0]+arr[i-2][1]);
            dp[i][1] = Math.min(Math.min(dp[i-1][0]+arr[i-1][0], dp[i-2][0]+arr[i-2][1]), dp[i-3][0]+bigJump);
        }
        System.out.println(Math.min(dp[N-1][0],dp[N-1][1]));
    }
}
