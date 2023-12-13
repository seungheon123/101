package com.example.demo.Day_18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int[][] arr;
    public static int[] dirx = {-1,0,1,0}; //북,동,남,서
    public static int[] diry = {0,1,0,-1};
    public static int N,M;
    public static int r,c,d;
    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        count++;
        solution(r,c,d);
        System.out.println(count);
    }

    public static void solution(int r, int c, int d){
        arr[r][c] = -1;
        for(int i = 0; i<4; i++){
            d = (d+3)%4;
            int new_r = r + dirx[d];
            int new_c = c + diry[d];
            if(new_c>=0 && new_c<M && new_r>=0 && new_r<N && arr[new_r][new_c]==0){
                count++;
                solution(new_r,new_c,d);
                return;
            }
        }
        int back = (d+2)%4;
        int new_r = r+dirx[back];
        int new_c = c+diry[back];
        if(new_r>=0 && new_r<N && new_c>=0 && new_c<M && arr[new_r][new_c]!=1){
            solution(new_r,new_c,d);
        }

    }
}
