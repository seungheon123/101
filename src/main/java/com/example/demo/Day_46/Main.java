package com.example.demo.Day_46;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int leaf = 0;
        int lastLeaf = 0;
        if(m==2){
            leaf = 1;
        }
        for(int i = 1; i<n; i++){
            if(m>leaf) {
                sb.append(0).append(" ").append(i).append("\n");
                leaf += 1;
            }else{
                sb.append(lastLeaf).append(" ").append(i).append("\n");
            }
            lastLeaf = i;
        }
        System.out.println(sb);
    }
}
