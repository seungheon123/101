package com.example.demo.Day_59;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static Integer[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new Integer[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, Collections.reverseOrder());
        double res = arr[0];
        for(int i = 1; i<N; i++){
            res += (double) arr[i] /2;
        }

        System.out.println(res);
    }
}
