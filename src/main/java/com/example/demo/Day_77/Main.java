package com.example.demo.Day_77;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        String[] title = new String[N];
        int[] value = new int[N];

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            title[i] = st.nextToken();
            value[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i<M; i++){
            int num = Integer.parseInt(br.readLine());
            int left = 0;
            int right = N-1;
            while(left<=right){
                int mid = (left + right) / 2;
                int val = value[mid];
                if(val < num) left = mid + 1;
                else right = mid - 1;
            }
            sb.append(title[left]).append("\n");
        }
        System.out.println(sb);
    }
}
