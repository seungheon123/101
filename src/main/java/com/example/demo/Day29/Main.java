package com.example.demo.Day29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            queue.add(Integer.parseInt(st.nextToken()));
        }
        for(int i = 0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                queue.add(Integer.parseInt(st.nextToken()));
                queue.poll();
            }
        }
        System.out.println(queue.poll());
    }
}
