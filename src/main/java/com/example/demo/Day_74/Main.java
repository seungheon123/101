package com.example.demo.Day_74;

import java.util.*;
import java.io.*;

public class Main {
    public static int N, M;
    public static char[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        for(int i = 0; i<N; i++){
            String str = br.readLine();
            for(int j =0; j<M; j++){
                arr[i][j] = str.charAt(j);
            }
        }
        int res = 0;
        for(int i = 0; i<M; i++){
            int[] dna = new int[4]; // A C G T
            for(int j = 0; j<N; j++){
                switch(arr[j][i]){
                    case 'T':
                        dna[3]++;
                        break;
                    case 'A':
                        dna[0]++;
                        break;
                    case 'G':
                        dna[2]++;
                        break;
                    case 'C':
                        dna[1]++;
                        break;
                }
            }
            int idx = -1;
            int max = 0;
            for(int k = 0; k<4; k++){
                if(dna[k]>max){
                    idx = k;
                    max = dna[k];
                }
            }
            res += (N - max);
            switch(idx){
                case 0:
                    sb.append('A');
                    break;
                case 1:
                    sb.append('C');
                    break;
                case 2:
                    sb.append('G');
                    break;
                case 3:
                    sb.append('T');
                    break;
            }
        }
        System.out.println(sb);
        System.out.println(res);
    }


}
