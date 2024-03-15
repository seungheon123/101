package com.example.demo.Day_58;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static int N;
    public static Integer[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new Integer[N];
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Long sum = 0L;
        Arrays.sort(arr, Collections.reverseOrder());
        int count = 0;
        for(int i = 0; i<N; i++){
            if(count == 2) {
                count=0;
                continue;
            }
            sum +=arr[i];
            count++;
        }
        System.out.println(sum);
    }
}
