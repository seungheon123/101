package com.example.demo.Day_42;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int N,M;
    public static int[][] arr;
    public static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0; i<T; i++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            arr = new int[N+1][N+1];
            visited = new boolean[N+1];
            for(int j = 0; j<M; j++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr[a][b] = arr[b][a] = 1;
            }
            System.out.println(bfs(1) - 1);
        }
    }

    public static int bfs(int num){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);
        visited[num] = true;
        int result = 0;
        while(!queue.isEmpty()){
            result++;
            int x = queue.poll();
            for(int i = 1; i<=N; i++){
                if(arr[x][i]==1 && !visited[i]){
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
        return result;
    }

}
