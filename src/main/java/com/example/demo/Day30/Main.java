package com.example.demo.Day30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            if(a == 0){
                if(!queue.isEmpty()){
                    sb.append(queue.poll()).append("\n");
                }else sb.append(-1).append("\n");
            }else{
                while(a-->0){
                    queue.offer(Integer.parseInt(st.nextToken()));
                }
            }
        }
        System.out.println(sb);
    }
}
