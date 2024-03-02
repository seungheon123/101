package com.example.demo.Day_51;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N, M;
    public static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for(int i = 0; i<N; i++){
            String str = br.readLine();
            for(int j = 0; j<M; j++){
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        int len = Math.min(N, M);

        while(len > 1) {
            for(int i = 0; i<=N-len; i++) {
                for(int j = 0; j<=M-len; j++){
                    int num = arr[i][j];
                    if(arr[i+len-1][j]==num && arr[i][j+len-1] == num && arr[i+len-1][j+len-1]==num) {
                        System.out.println(len*len);
                        return;
                    }

                }
            }
            len--;
        }
        System.out.println(len*len);
    }
}
