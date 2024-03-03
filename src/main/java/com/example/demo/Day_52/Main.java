package com.example.demo.Day_52;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int R, C;
    public static char[][] arr;
    public static boolean[][] isSea;
    public static int[] dirX = {-1,1,0,0};
    public static int[] dirY = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R][C];
        isSea = new boolean[R][C];
        for(int i =0; i<R; i++){
            String str = br.readLine();
            for(int j =0; j<C; j++){
                arr[i][j] = str.charAt(j);
            }
        }
        int minY = C;
        int minX = R;
        int maxY = 0;
        int maxX = 0;
        for(int i =0; i<R; i++) {
            for(int j = 0; j<C; j++) {
                int count = 0;
                char ch = arr[i][j];
                if(ch == '.') continue;
                if(ch == 'X') {
                    for(int k =0; k<4; k++) {
                        int nX = i + dirX[k];
                        int nY = j + dirY[k];
                        if(nX <0 || nY <0 || nX >=R || nY >=C) count++;
                        else if(arr[nX][nY] == '.') count++;
                    }
                }
                if (count >=3) isSea[i][j] = true;
                else {
                    maxX = Math.max(maxX, i);
                    minX = Math.min(minX, i);
                    maxY = Math.max(maxY, j);
                    minY = Math.min(minY, j);
                }
            }
        }
        for(int i = 0; i<R; i++) {
            for(int j = 0; j<C; j++ ){
                if(isSea[i][j]) arr[i][j] = '.';
            }
        }
        for(int i = minX; i<=maxX; i++){
            for(int j = minY; j<=maxY; j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

    }
}
