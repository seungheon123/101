package com.example.demo.Day25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Deque<Integer> deque = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());
            if(arr[i]==0){
                deque.offerLast(num);
            }
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<M; i++){
            deque.offerFirst(Integer.parseInt(st.nextToken()));
            sb.append(deque.pollLast()).append(" ");
        }
        System.out.println(sb);

    }
}
