package com.example.demo.Day_71;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N, M, K;
    public static boolean[][] arr;
    public static boolean[][] visited;
    public static int[] dir_x = {-1,1,0,0};
    public static int[] dir_y = {0,0,-1,1};
    public static int max = 0;
    public static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new boolean[N+1][M+1];
        visited = new boolean[N+1][M+1];
        for(int i = 0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = true;
        }

        for(int i=0; i<N+1; i++){
            for(int j=0; j<M+1; j++){
                if(arr[i][j]) {
                    count = 0;
                    dfs(i,j);
                    max = Math.max(max, count);
                }
            }
        }
        System.out.println(max);
    }

    public static void dfs(int x, int y){
        count++;
        visited[x][y] = true;
        for(int i = 0; i<4; i++){
            int newX = x + dir_x[i];
            int newY = y + dir_y[i];
            if(newX<0 || newY<0 || newX>=N+1 || newY>=M+1) continue;
            if(arr[newX][newY] && !visited[newX][newY]) {
                dfs(newX,newY);
            }
        }
    }

}
