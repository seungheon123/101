package com.example.demo.Day_54;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[][] map = new int[5][5];
    public static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int i = 0; i<5; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<5; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int turn = 1;
        for(int i = 0; i<5; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<5; j++){
                int num = Integer.parseInt(st.nextToken());
                find(num);
                col();
                row();
                diag_r();
                diag_l();
                if(cnt>=3) {
                    System.out.println(turn);
                    System.exit(0);
                }
                cnt = 0;
                turn++;
            }
        }
    }

    public static void find(int num){
        for(int i = 0; i<5; i++){
            for(int j = 0; j<5; j++){
                if(map[i][j]==num) {
                    map[i][j] = 0;
                    return;
                }
            }
        }
    }

    public static void col(){
        int count = 0;
        for(int i = 0; i<5; i++){
            for(int j = 0; j<5; j++){
                if(map[i][j]==0) count++;
                if(count==5) cnt++;
            }
            count = 0;
        }
    }

    public static void row(){
        int count = 0;
        for(int i = 0; i<5; i++){
            for(int j = 0; j<5; j++){
                if(map[j][i]==0) count++;
                if(count==5) cnt++;
            }
            count = 0;
        }
    }

    public static void diag_r(){
        int count = 0;
        for(int i = 0; i<5; i++){
            if(map[i][4-i]==0) count++;
            if(count==5) cnt++;
        }
    }

    public static void diag_l(){
        int count = 0;
        for(int i = 0; i<5; i++){
            if(map[i][i]==0) count++;
            if(count==5) cnt++;
        }
    }
}
