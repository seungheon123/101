package com.example.demo.Day_31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int a = Integer.parseInt(br.readLine());
        int res = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i<N-1; i++){
            int num = Integer.parseInt(br.readLine());
            queue.add(num);
        }
        while(!queue.isEmpty() && queue.peek()>=a){
            res++;
            a++;
            queue.add(queue.poll()-1);
        }
        System.out.println(res);
    }
}
