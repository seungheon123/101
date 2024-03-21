package com.example.demo.Day_64;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            int n = Integer.parseInt(br.readLine());
            int[][] stickers = new int[2][n];
            int[][] dp = new int[2][n];
            for(int i = 0; i<2; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j<n; j++){
                    stickers[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int res = Integer.MIN_VALUE;
            for(int i = 0; i<n; i++){
                if(i == 0) {
                    dp[0][0] = stickers[0][0];
                    dp[1][0] = stickers[1][0];
                    res = Math.max(dp[0][i],dp[1][i]);
                    continue;
                }
                if(i == 1) {
                    dp[0][1] = stickers[1][0] + stickers[0][1];
                    dp[1][1] = stickers[0][0] + stickers[1][1];
                    res = Math.max(dp[0][i],dp[1][i]);
                    continue;
                }
                dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + stickers[0][i];
                dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + stickers[1][i];
                res = Math.max(dp[0][i],dp[1][i]);
            }
            System.out.println(res);
        }

    }

}
