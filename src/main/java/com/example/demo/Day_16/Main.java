package com.example.demo.Day_16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int K;
    public static int L;
    public static int[] x_dir = {0,1,0,-1};
    public static int[] y_dir = {1,0,-1,0};
    public static HashMap<Integer,String> hash = new HashMap<>();

    public static List<int[]> snake = new LinkedList<>();

    public static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        snake.add(new int[]{1,1});

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        arr = new int[N+1][N+1];
        for(int i = 0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = 1;
        }
        L = Integer.parseInt(br.readLine());
        while(L-->0){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            String c = st.nextToken();
            hash.put(x,c);
        }
        int result = solve();
        System.out.println(result);

    }

    public static int solve(){
        int time = 0;
        int new_x = 1;
        int new_y = 1;
        int d = 0;
        boolean isCollision = false;
        while(true){
            time++;
            new_x +=x_dir[d];
            new_y +=y_dir[d];

            //범위를 벗어나거나 뱀 몸통을 만나면 종료
            if(new_x<1 || new_x>N || new_y<1 || new_y>N) break;
            for (int[] temp : snake) {
                if (new_x == temp[0] && new_y == temp[1]){
                    isCollision = true;
                    break;
                }
            }
            if(isCollision) break;

            if(arr[new_x][new_y]==1){
                arr[new_x][new_y]=0;
                snake.add(new int[]{new_x,new_y});
            }else{
                snake.add(new int[]{new_x,new_y});
                snake.remove(0);
            }

            if(hash.containsKey(time)){
                if(hash.get(time).equals("D")){
                    d+=1;
                    if(d==4) d = 0;
                }else{
                    d-=1;
                    if(d==-1) d = 3;
                }
            }
        }
        return time;
    }
}
