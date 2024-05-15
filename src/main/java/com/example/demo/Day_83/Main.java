package com.example.demo.Day_83;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static int N,M;
    public static int[] train;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        train = new int[N+1];

        for (int j = 0; j < M; j++) {
            execute(br.readLine());
        }

        HashSet<Integer> set = new HashSet<>();
        for(int i=1;i<N+1;i++) {
            set.add(train[i]);
        }

        // 출력
        System.out.println(set.size());

    }

    public static void execute(String command){
        StringTokenizer st = new StringTokenizer(command);
        int c = Integer.parseInt(st.nextToken());
        int i = Integer.parseInt(st.nextToken());
        int x = -1;

        switch (c){
            case 1:
                x += Integer.parseInt(st.nextToken());
                train[i] |= (1 << x);
                break;
            case 2:
                x += Integer.parseInt(st.nextToken());
                train[i] &= ~(1 << x);
                break;
            case 3:
                train[i] = (train[i] &~(1<<19)) <<1;
                break;
            case 4:
                train[i] = (train[i] &~(1)) >>1;
                break;
        }
    }
}
