package com.example.demo.Day20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static char[][] arr;
    public static int[] dir_x = {-1,1,0,0};
    public static int[] dir_y = {0,0,-1,1};
    public static int max = 0;
    public static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        for(int i = 0; i<N; i++){
            String str = br.readLine();
            for(int j = 0; j<N; j++){
                arr[i][j] = str.charAt(j);
            }
        }
        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                if(i+1<N){
                    swap(i,j,i+1,j);
                    max = Math.max(max,Col(j));
                    max = Math.max(max,Row(i));
                    max = Math.max(max,Row(i+1));
                    swap(i,j,i+1,j);
                }
                if(j+1<N){
                    swap(i,j,i,j+1);
                    max = Math.max(max,Col(j));
                    max = Math.max(max,Row(i));
                    max = Math.max(max,Col(j+1));
                    swap(i,j,i,j+1);
                }
            }
        }
        System.out.println(max);
    }

    public static int Row(int x){
        int res = 1, temp = 1;
        char ch = arr[x][0];
        for(int i = 1; i<N; i++){
            if(arr[x][i]!=ch){
                ch = arr[x][i];
                res = Math.max(res,temp);
                temp = 1;
            }else temp++;
        }
        return Math.max(res,temp);
    }

    public static int Col(int y){
        int res = 1, temp = 1;
        char ch = arr[0][y];
        for(int i = 1; i<N; i++){
            if(arr[i][y]!=ch){
                ch = arr[i][y];
                res = Math.max(res,temp);
                temp = 1;
            }else temp++;
        }
        return Math.max(res,temp);
    }

    public static void swap(int x, int y, int nx, int ny){
        char temp = arr[x][y];
        arr[x][y] = arr[nx][ny];
        arr[nx][ny] = temp;
    }

}
