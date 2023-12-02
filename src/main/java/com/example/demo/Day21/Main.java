package com.example.demo.Day21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String N = br.readLine();
        int max = 0;
        int total = 0;
        int[] arr = new int[N.length()];
        for(int i = 0; i<N.length(); i++){
            int x = Integer.parseInt(N.substring(i,i+1));
            arr[i] = x;
            total +=x;
        }
        Arrays.sort(arr);
        if(!N.contains("0") || total%3!=0){
            System.out.println(-1);
        }else {
            for (int i = N.length() - 1; i >= 0; i--) {
                sb.append(arr[i]);
            }
            System.out.println(sb);
        }
    }
}
