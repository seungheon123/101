package com.example.demo.Day_37;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static boolean[] visited;
    public static int res = -1;
    public static int num1, num2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i<n+1; i++) graph.add(new ArrayList<>());
        visited = new boolean[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        num1 = Integer.parseInt(st.nextToken());
        num2 = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        dfs(num1,num2,0);
        System.out.println(res);
    }

    public static void dfs(int start,int end,int cnt){
        if(start == end){
            res = cnt;
            return;
        }
        visited[start] = true;
        for (Integer i : graph.get(start)) {
            if(!visited[i]){
                dfs(i,end,cnt+1);
            }

        }

    }

}
