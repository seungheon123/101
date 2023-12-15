package com.example.demo.Day_33;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int range = (int)(arr[0]-0.5+L);
        int res = 1;
        for(int i = 0; i<N; i++){
            if(range<(int)(arr[i]+0.5)){
                range = (int)(arr[i]-0.5+L);
                res++;
            }
        }
        System.out.println(res);
    }
}
