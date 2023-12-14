package com.example.demo.Day_32;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int totalPrice = 1001;
        int singlePrice = 1001;
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            totalPrice = Math.min(totalPrice,Integer.parseInt(st.nextToken()));
            singlePrice = Math.min(singlePrice,Integer.parseInt(st.nextToken()));
        }
        if(singlePrice*6<totalPrice){
            System.out.println(singlePrice*N);
            return;
        }
        int total = totalPrice*(N/6);
        total += Math.min(singlePrice*(N%6),totalPrice);
        System.out.println(total);

    }
}
