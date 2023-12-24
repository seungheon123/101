package com.example.demo.Day_39;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[][] arr;
    public static boolean[][] visited;
    public static int[] dirX = {-1,1,0,0};
    public static int[] dirY = {0,0,-1,1};
    public static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        StringTokenizer st;
        int maxHigh = 0;
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j]>maxHigh) maxHigh = arr[i][j];
            }
        }
        int max = 0;
        for(int k = 0; k<maxHigh+1; k++) {
            visited = new boolean[N][N];
            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][j] > k && !visited[i][j]) {
                        count++;
                        dfs(i, j, k);
                    }
                }
            }

            max = Math.max(max,count);
        }
        System.out.println(max);

    }
    public static void dfs(int x, int y, int high){
        visited[x][y] = true;
        for(int i = 0; i<4; i++){
            int newX = x+dirX[i];
            int newY = y+dirY[i];
            if(newX<0 || newX>=N || newY<0 || newY>=N) continue;
            if(arr[newX][newY]>high && !visited[newX][newY]){
                dfs(newX,newY,high);
            }
        }
    }
}
