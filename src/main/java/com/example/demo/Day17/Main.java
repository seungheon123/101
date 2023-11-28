package com.example.demo.Day17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int[][] gear = new int[4][8];
    public static int K;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int res = 0;
        for(int i = 0; i<4; i++){
            String str = br.readLine();
            for(int j = 0; j<8; j++){
                gear[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }
        K = Integer.parseInt(br.readLine());
        for(int i = 0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken());

            int[] directions = calDirection(a,b);
            for(int j = 0; j<4; j++){
                if(directions[j]!=0){
                    turn(j,directions[j]);
                }
            }
        }

        if(gear[0][0]==1) res +=1;
        if(gear[1][0]==1) res +=2;
        if(gear[2][0]==1) res +=4;
        if(gear[3][0]==1) res +=8;

        System.out.println(res);
    }

    public static int[] calDirection(int num, int dir){
        int[] direction = new int[4];
        direction[num] = dir;

        for(int i = num; i>0; i--){
            if(gear[i][6]==gear[i-1][2]) break;
            direction[i-1] = direction[i] * -1; //반대로 돌기 때문
        }

        for(int i = num; i<3; i++){
            if(gear[i][2]==gear[i+1][6]) break;
            direction[i+1] = direction[i] * -1;
        }
        return direction;
    }

    public static void turn(int wheel, int dir){
        if(dir == 1) {
            int temp = gear[wheel][7];
            for (int i = 7; i > 0; i--) {
                gear[wheel][i] = gear[wheel][i - 1];
            }
            gear[wheel][0] = temp;
        }else{
            int temp = gear[wheel][0];
            for(int i = 0; i<7; i++){
                gear[wheel][i] = gear[wheel][i+1];
            }
            gear[wheel][7] = temp;
        }
    }



}
