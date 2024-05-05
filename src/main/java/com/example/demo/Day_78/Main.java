package com.example.demo.Day_78;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int H, W, X, Y;
    public static int[][] A;
    public static int[][] B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        A = new int[H][W];
        B = new int[H+X][W+Y];
        for(int i = 0; i<H+X; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<W+Y; j++){
                B[i][j]= Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i<X; i++){
            for(int j =0; j<W; j++){
                A[i][j] = B[i][j];
            }
        }
        for(int i = X; i<H; i++){
            for(int j = 0; j<Y; j++){
                A[i][j] = B[i][j];
            }
        }

        for(int i = X; i<H; i++){
            for(int j = Y; j<W; j++){
                A[i][j] = B[i][j] - A[i-X][j-Y];
            }
        }

        for(int i = 0; i<H; i++){
            for(int j = 0; j<W; j++){
                System.out.print(A[i][j]+" ");
            }
            System.out.println();
        }

    }
}
