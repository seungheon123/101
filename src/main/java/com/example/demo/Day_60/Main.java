package com.example.demo.Day_60;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static long[] arr;
    public static long max = 0;
    public static int N;
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);
        if(N==1) {
            System.out.println(arr[0]);
            System.exit(0);
        }
        if(N%2==0) even();
        else odd();
        System.out.println(max);
    }

    public static void even(){
        for(int i = 0; i<N/2; i++) {
            Long loss = arr[i] + arr[N-i-1];
            max = Math.max(max, loss);
        }
    }

    public static void odd(){
        max = Math.max(max, arr[N-1]);
        for(int i = 0; i<N/2; i++){
            Long loss = arr[i] + arr[N-i-2];
            max = Math.max(max, loss);
        }
    }
}

