package com.example.demo.Day_70;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int N, M, V;
    public static boolean[][] arr;
    public static boolean[] visited;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        arr = new boolean[N+1][N+1];
        visited = new boolean[N+1];

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = true;
            arr[y][x] = true;
        }
        dfs(V);
        for(int i = 0; i<N+1; i++) visited[i] = false;
        sb.append("\n");
        bfs(V);
        System.out.println(sb);
    }

    public static void dfs(int start){
        visited[start] = true;
        sb.append(start).append(" ");
        for(int i = 1; i<=N; i++){
            if(arr[start][i] && !visited[i]) dfs(i);
        }
    }

    public static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);
        while(!queue.isEmpty()){
            int num = queue.poll();
            sb.append(num).append(" ");
            for(int i = 1; i<N+1; i++){
                if(arr[num][i] && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

}
