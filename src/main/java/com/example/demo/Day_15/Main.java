package com.example.demo.Day_15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int K;
    public static int[] arr;
    public static int res = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        for(int i =2; i<N+1; i++){
            arr[i] = i;
        }
        solution();

    }

    static void solution(){
        for(int i =2; i<N+1; i++){
            if(arr[i]==0) continue;
            for(int j = i; j<N+1; j+=i){
                if(arr[j]!=0){
                    res = arr[j];
                    arr[j]=0;
                    K--;
                }
                if(K==0) {
                    System.out.println(res);
                    return;
                }
            }
        }
    }
}
