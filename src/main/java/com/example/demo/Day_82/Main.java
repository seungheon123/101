package com.example.demo.Day_82;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[][] arr = new int[19][19];
    public static int[][] dir = {{0,1},{1,0},{1,1},{-1,1}};
    public static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int i = 0; i<19; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int resultX = 0;
        int resultY = 0;
        for(int i = 0; i<19; i++){
            if(flag) break;
            for (int j = 0; j < 19; j++) {
                if(arr[i][j] == 0) continue;
                flag = check(i, j);
                if(flag){
                    resultX = i+1;
                    resultY = j+1;
                    break;
                }
            }
        }
        if(flag){
            System.out.println(arr[resultX-1][resultY-1]);
            System.out.println(resultX+" "+resultY);
        } else System.out.print(0);
    }

    public static boolean check(int x, int y){
        boolean check = false;
        for(int i = 0; i<4; i++){
            check = false;
            int count = 1;
            int newX = x + dir[i][0];
            int newY = y + dir[i][1];
            if(newX < 0 || newY < 0 || newX >=19 || newY >=19) continue;
            while(true){
                if(count == 5) {
                    check = true;
                    break;
                }
                if(newX < 0 || newY < 0 || newX >=19 || newY >=19) break;
                if(arr[newX][newY] == arr[x][y]){
                    count++;
                    newX +=dir[i][0];
                    newY +=dir[i][1];
                } else break;
            }
            if (check) {
                if(newX >=0 && newY>=0 && newX<19 && newY<19){
                    if(arr[newX][newY]==arr[x][y]) check = false;
                }
            }
            if(check){
                int nX = x - dir[i][0];
                int nY = y - dir[i][1];
                if(nX >= 0 && nY >= 0 && nX <19 && nY <19){
                    if(arr[nX][nY] == arr[x][y]) check = false;
                }
            }
            if(check) break;

        }
        return check;
    }
}
