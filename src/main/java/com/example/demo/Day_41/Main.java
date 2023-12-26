package com.example.demo.Day_41;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Tomato{
    int x;
    int y;
    int z;
    public Tomato(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
public class Main {
    public static int M,N,H;
    public static int[][][] arr;
    public static Queue<Tomato> queue = new LinkedList<>();
    static int[] dirX = {-1, 1, 0, 0, 0, 0};
    static int[] dirY = {0, 0, -1, 1, 0, 0};
    static int[] dirZ = {0, 0, 0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        arr = new int[H][N][M];
        for(int i = 0; i<H; i++){
            for(int j = 0; j<N; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k<M; k++){
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                    if(arr[i][j][k]==1) queue.add(new Tomato(j,k,i));
                }
            }
        }
        bfs();
        int res = 0;
        for(int i = 0; i<H; i++){
            for(int j = 0; j<N; j++){
                for(int k = 0; k<M; k++){
                    if(arr[i][j][k]==0){
                        System.out.println(-1);
                        return;
                    }
                    res = Math.max(res,arr[i][j][k]);
                }
            }
        }
        if(res == 1){
            System.out.println(0);
            return;
        }
        System.out.println(res-1);

    }

    public static void bfs(){
        while(!queue.isEmpty()){
            Tomato tomato = queue.poll();
            int x= tomato.x;
            int y = tomato.y;
            int z = tomato.z;
            for(int i = 0; i<6; i++){
                int newX = x + dirX[i];
                int newY = y + dirY[i];
                int newZ = z + dirZ[i];
                if(!check(newX,newY,newZ)) continue;
                queue.offer(new Tomato(newX,newY,newZ));
                arr[newZ][newX][newY] = arr[z][x][y]+1;
            }
        }
    }

    public static boolean check(int x, int y, int z){
        if(x<0 || x>=N || y<0 || y>=M || z<0 || z>=H) return false;
        if(arr[z][x][y]==0) return true;
        else return false;
    }


}

