package com.example.demo.Day_72;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static int T;
    public static int[][] score;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        while (T-->0){
            int N = Integer.parseInt(br.readLine());
            int cnt = 0;
            score = new int[N][2];
            for(int i = 0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                score[i][0] = Integer.parseInt(st.nextToken());
                score[i][1] = Integer.parseInt(st.nextToken());
            }
//            Arrays.sort(score, new Comparator<int[]>() {
//                @Override
//                public int compare(int[] o1, int[] o2) {
//                    return Integer.compare(o1[0], o2[0]);
//                }
//            });
            Arrays.sort(score, (o1,o2)-> Integer.compare(o1[0],o2[0]));
            cnt = 1;
            int min = score[0][1];
            for(int i = 1; i<N; i++){
                if(score[i][1] < min) {
                    cnt++;
                    min = score[i][1];
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
