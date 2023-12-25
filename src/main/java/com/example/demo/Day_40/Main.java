package com.example.demo.Day_40;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static int[][] arr;
    public static int count;
    public static int[] dirX = {-1,1,0,0};
    public static int[] dirY = {0,0,-1,1};
    public static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        arr = new int[M][N];
        for(int i = 0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for(int j = y1; j<y2; j++){
                for(int k = x1; k<x2; k++){
                    arr[j][k] = 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i = 0; i<M; i++){
            for(int j = 0; j<N; j++){
                if(arr[i][j]==0){
                    count = 1;
                    dfs(i,j);
                    arrayList.add(count);
                }
            }
        }
        Collections.sort(arrayList);
        sb.append(arrayList.size()).append("\n");
        for (Integer i : arrayList) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

    public static void dfs(int y, int x){
        arr[y][x] = 1;
        for(int i = 0; i<4; i++){
            int newX = x + dirX[i];
            int newY = y + dirY[i];
            if(newX>=0 && newY >=0 && newX<N && newY<M && arr[newY][newX]==0) {
                count++;
                dfs(newY,newX);
            }
        }
    }
}
