package com.example.demo.Day_47;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        int []arr = new int[N];
        int []sorted = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sorted[i] = arr[i];
        }
        Arrays.sort(sorted);
        int rank = 0;
        for (int i : sorted) {
            if(!hashMap.containsKey(i)){
                hashMap.put(i,rank);
                rank++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(hashMap.get(i)).append(" ");
        }
        System.out.println(sb);

    }
}
