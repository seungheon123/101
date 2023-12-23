package com.example.demo.Day_38;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    public static int[] parent;
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        parent = new int[N+1];
        visited = new boolean[N+1];
        for(int i = 0; i<N+1; i++) list.add(new ArrayList<>());
        StringTokenizer st;
        for(int i = 0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        dfs(1);
        StringBuilder sb = new StringBuilder();
        for(int i = 2; i<N+1; i++){
            sb.append(parent[i]).append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int n){
        visited[n] = true;
        for (Integer i : list.get(n)) {
            if(!visited[i]){
                parent[i] = n;
                dfs(i);
            }
        }
    }
}
