package com.example.demo.Day_65;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int[][] arr;
    public static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        dp = new long[N][N];
        StringTokenizer st;
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = 1;
        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                int current = arr[i][j];
                if(current == 0) break;
                if(i+current<N) dp[i+current][j] +=dp[i][j];
                if(j+current<N) dp[i][j+current] +=dp[i][j];
            }
        }
        System.out.println(dp[N-1][N-1]);
    }
}
