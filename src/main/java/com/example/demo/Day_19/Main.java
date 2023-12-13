package com.example.demo.Day_19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int[][] arr;
    public static int time = 100000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        int min = 256;
        int max = 0;

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(min>arr[i][j]) min = arr[i][j];
                if(max<arr[i][j]) max = arr[i][j];
            }
        }

        int high = 0;
        for(int i = min; i<=max; i++){
            int block = B;
            int count = 0;
            for(int j = 0; j<N; j++){
                for(int k = 0; k<M; k++){
                    if(arr[j][k]>i){
                        count +=((arr[j][k]-i)*2);
                        block +=(arr[j][k]-i);
                    }else{
                        count +=(i-arr[j][k]);
                        block -=(i-arr[j][k]);
                    }
                }
            }
            if(block<0) break;
            if(time>=count){
                time = count;
                high = i;
            }
        }
        sb.append(time).append(" ").append(high);
        System.out.println(sb);

    }
}
