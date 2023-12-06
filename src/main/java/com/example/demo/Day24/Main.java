package com.example.demo.Day24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int area = 0;
        int[] arr = new int[1001];
        int N = Integer.parseInt(br.readLine());
        int start = Integer.MAX_VALUE;
        int end = 0;
        int mid = 1;
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            arr[L] = H;
            start = Math.min(L,start);
            end = Math.max(L,end);
            if(arr[L]>arr[mid]){
                mid = L;
            }
        }
        int height = 0;
        for(int i = start; i<mid; i++){
            height = Math.max(height,arr[i]);
            area+=height;
        }
        height = 0;
        for(int i = end; i>mid; i--){
            height = Math.max(height,arr[i]);
            area+=height;
        }
        System.out.println(area+arr[mid]);





    }
}
