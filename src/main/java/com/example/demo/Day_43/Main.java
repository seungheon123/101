package com.example.demo.Day_43;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int l, a, b, c, d;
    public static int[][] chess;
    public static boolean[][] visited;
    public static int[] dirX = {1,2,2,1,-1,-2,-2,-1};
    public static int[] dirY = {2,1,-1,-2,-2,-1,1,2};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i<T; i++){
            l = Integer.parseInt(br.readLine());
            chess = new int[l][l];
            visited = new boolean[l][l];
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            c = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());

            bfs(a,b);
            sb.append(chess[c][d]).append("\n");
        }
        System.out.println(sb);
    }

    public static void bfs(int a, int b){
        Queue<Queen> queue = new LinkedList<>();
        queue.add(new Queen(a,b));
        visited[a][b] = true;
        while (!queue.isEmpty()){
            Queen queen = queue.poll();
            int x = queen.x;
            int y = queen.y;
            for(int i = 0; i<8; i++){
                int newX = x + dirX[i];
                int newY = y + dirY[i];
                if(newX>=0 && newX<l && newY>=0 && newY<l){
                    if(!visited[newX][newY]){
                        queue.add(new Queen(newX,newY));
                        chess[newX][newY] = chess[x][y]+1;
                        visited[newX][newY] = true;
                    }
                }
            }
        }

    }

}

class Queen{
    int x;
    int y;

    public Queen(int x, int y){
        this.x = x;
        this.y = y;
    }
}
