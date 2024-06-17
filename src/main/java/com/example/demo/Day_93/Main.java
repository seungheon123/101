package com.example.demo.Day_93;

import java.io.*;
import java.util.*;

class Main {
    public static int N, T;
    public static char[][] arr;
    public static int[] dirX = {-1,1,0,0};
    public static int[] dirY = {0,0,-1,1};
    public static int max = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        arr = new char[N][N];
        int x = 0;
        int y = 0;
        for(int i = 0; i<N; i++){
            String input = br.readLine();
            for(int j = 0; j<N; j++){
                arr[i][j] = input.charAt(j);
                if(input.charAt(j) == 'S'){
                    x = i;
                    y = j;
                }
            }
        }
        boolean[][] visited = new boolean[N][N];
        check(x,y, 0, 0, visited);
        System.out.println(max);
    }


    public static void check(int x, int y, int time, int count, boolean[][] visited){
        int K = count;
        if(arr[x][y] == 'O' && !visited[x][y]){
            K +=1;
            visited[x][y] = true;
        }
        if(time == T){
            max = Math.max(max, K);
            return;
        }
        for(int i = 0; i<4; i++){
            int nx = x + dirX[i];
            int ny = y + dirY[i];
            if(nx <0 || ny<0 || nx>=N || ny>=N) continue;
            if(arr[nx][ny] == '#') continue;
            check(nx,ny,time+1, K, visited);
        }
    }
}













