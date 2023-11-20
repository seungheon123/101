package com.example.demo.Day9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];
        for(int i = 1; i<n+1; i++){
            parent[i] = i;
        }
        while(m-->0){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(x==0){
                union(a,b);
            }
            else if(x==1){
                if(find(a)==find(b)) sb.append("YES").append("\n");
                else sb.append("NO").append("\n");
            }

        }
        System.out.println(sb);
    }


    public static int find(int a){
        if(parent[a] == a) return a;
        else return find(parent[a]);
    }

    public static void union(int x, int y){
        int a = find(x);
        int b = find(y);
        if(a!=b){
            parent[b] = a;
        }
    }
}
