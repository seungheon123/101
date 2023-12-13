package com.example.demo.Day_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int T;
    public static int N;
    public static int M;
    public static int[] arr1;
    public static int[] arr2;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        while(T>0) {
            N = Integer.parseInt(br.readLine());
            arr1 = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr1[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr1);
            M = Integer.parseInt(br.readLine());
            arr2 = new int[M];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int res = binarySearch(Integer.parseInt(st.nextToken()), 0, N - 1);
                sb.append(res).append("\n");
            }
            T--;
        }
        System.out.println(sb);
    }

    private static int binarySearch(int n, int start, int end) {
        if(start>end) return 0;
        int mid = (start + end)/2;
        if(arr1[mid] == n) return 1;
        else if(arr1[mid]>n) return binarySearch(n,start,mid-1);
        else return binarySearch(n,mid+1,end);

    }

}


