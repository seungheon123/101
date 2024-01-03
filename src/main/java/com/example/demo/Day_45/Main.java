package com.example.demo.Day_45;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int n,m;
    public static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        for(int i = 0; i<=n; i++) arrayList.add(new ArrayList<Integer>());
        visited = new boolean[n+1];
        StringTokenizer st;
        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arrayList.get(a).add(b);
            arrayList.get(b).add(a);
        }
        visited[1] = true;
        dfs(0,1);
        int count = 0;
        for(int i = 0; i<=n; i++){
            if(visited[i]) count++;
        }
        System.out.println(count-1);
    }
    public static void dfs(int depth, int start){
        if(depth==2){
            return;
        }
        for (int i : arrayList.get(start)) {
            visited[i] = true;
            dfs(depth+1, i);
        }
    }
}
