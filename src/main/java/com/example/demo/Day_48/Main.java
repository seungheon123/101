package com.example.demo.Day_48;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        int []arr = new int[10];
        for(int i = 0; i<N.length(); i++){
            int n = Character.getNumericValue(N.charAt(i));
            arr[n]++;
        }
        int k = arr[6] + arr[9];
        if(k % 2 ==0){
            arr[6] = k / 2;
            arr[9] = k / 2;
        } else{
            arr[6] = k/2 + 1;
            arr[9] = k/2 + 1;
        }
        int max = 0;
        for(int i : arr){
            max = Math.max(max,i);
        }
        System.out.println(max);

    }
}
