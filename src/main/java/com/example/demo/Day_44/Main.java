package com.example.demo.Day_44;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;


public class Main {
    public static int N,M;
    public static int[][] arr;
    public static List<Integer>[] list;
    public static boolean[] visited;
    public static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        for(int i = 0; i<N+1; i++) list[i] = new ArrayList<>();
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            list[B].add(A);
        }
        result = new int[N+1];
        for(int i = 1; i<=N; i++){
            visited = new boolean[N+1];
            bfs(i);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        int max_value = 0;
        for(int i=1;i<=N;i++){
            if(result[i] > max_value){
                max_value = result[i];
                ans.clear();
                ans.add(i);
            } else if (result[i] == max_value){
                ans.add(i);
            }
        }

        for(int a:ans){
            System.out.print(a+" ");
        }
    }

    public static void bfs(int num){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);
        visited[num] = true;
        while(!queue.isEmpty()){
            int a = queue.poll();
            for(int i : list[a]){
                if(!visited[i]){
                    result[i]++;
                    queue.add(i);
                    visited[i] = true;
                }

            }
        }
    }
}

