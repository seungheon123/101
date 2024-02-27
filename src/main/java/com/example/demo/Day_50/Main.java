package com.example.demo.Day_50;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[] arr;
    public static int H, W;
    public static int top = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        arr = new int[W];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<W; i++) {
            int k = Integer.parseInt(st.nextToken());
            arr[i] = k;
            top = Math.max(top, k);
        }
        int result = 0;
        for(int i = 1; i<W-1; i++) {
            int left = leftMax(i);
            int right = rightMax(i);
            int min = Math.min(left, right);
            result += (min - arr[i]);
        }
        System.out.println(result);
    }

    static int leftMax(int index) {
        int max = arr[index];
        //if(arr[index] == top) return arr[index];
        for(int i = index-1; i>=0; i--) {
            if(arr[i] == H) return H;
            max = Math.max(arr[i], max);
        }
        return max;
    }
    static int rightMax(int index) {
        int max = arr[index];
        //if(arr[index] == top) return arr[index];
        for(int i = index +1; i<=W-1; i++) {
            if(arr[i]==H) return H;
            max = Math.max(arr[i], max);
        }
        return max;
    }

}
