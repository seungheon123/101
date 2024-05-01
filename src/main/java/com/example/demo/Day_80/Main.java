package com.example.demo.Day_80;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N, M;
    public static int[][] maze;
    public static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maze = new int[N][M];
        dp = new int[N][M];
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                maze[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = maze[0][0];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(i == 0 && j == 0) continue;
                else if (i == 0) {
                    dp[i][j] = dp[i][j-1]+maze[i][j];
                }
                else if(j == 0){
                    dp[i][j] = dp[i-1][j]+maze[i][j];
                }
                else {
                    dp[i][j] = maze[i][j] + Math.max(Math.max(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]);
                }
            }
        }

        System.out.println(dp[N-1][M-1]);

    }
}
