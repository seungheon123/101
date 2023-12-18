package com.example.demo.Day_35;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;

public class Main {
    static int w;
    static int h;
    static int count;

    static int[][] arr;
    static boolean[][] visited;
    static int[] x_dir = {-1,1,0,0,1,1,-1,-1};
    static int[] y_dir = {0,0,-1,1,-1,1,-1,1};
    static Queue<Pair> que = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            w = sc.nextInt();
            h = sc.nextInt();
            arr = new int[h][w];
            visited = new boolean[h][w];
            if(w == 0 && h == 0) break;
            count = 0;
            for(int i =0; i<h; i++){
                for(int j =0; j<w; j++){
                    int a = sc.nextInt();
                    arr[i][j] = a;
                }
            }
            for(int i =0; i<h; i++){
                for(int j = 0; j<w; j++){
                    if(!visited[i][j] && arr[i][j]==1){
                        bfs(i,j);
                        count++;
                    }
                }
            }
            System.out.println(count);

        }
    }

    static void bfs(int x, int y){
        visited[x][y] = true;
        que.add(new Pair(x,y));
        while(!que.isEmpty()){
            x = que.peek().x;
            y = que.poll().y;
            for(int i =0; i<8; i++){
                int new_x = x + x_dir[i];
                int new_y = y + y_dir[i];
                if (new_x < 0 || new_x >= h || new_y < 0 || new_y >= w) continue;
                if(!visited[new_x][new_y] && arr[new_x][new_y]==1){
                    visited[new_x][new_y] = true;
                    que.add(new Pair(new_x,new_y));
                }
            }
        }
    }

    static class Pair{
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


}
