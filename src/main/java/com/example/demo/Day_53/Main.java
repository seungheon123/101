package com.example.demo.Day_53;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static int T, n, k, t, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while(T-->0){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); //팀 수
            k = Integer.parseInt(st.nextToken()); //문제수
            t = Integer.parseInt(st.nextToken()); //내 팀ID
            m = Integer.parseInt(st.nextToken()); //로그 개수
            Team[] list = new Team[n];
            for(int i = 0; i<m; i++){
                st = new StringTokenizer(br.readLine());
                int team = Integer.parseInt(st.nextToken()); //팀ID
                int problem = Integer.parseInt(st.nextToken()); //문제ID
                int score = Integer.parseInt(st.nextToken()); //점수

                if(list[team-1] == null) {
                    list[team-1] = new Team();
                    list[team-1].id = team;
                    list[team-1].score = new int[k+1];
                    list[team-1].submitNum = 0;
                }
                list[team-1].score[problem] = Math.max(score, list[team-1].score[problem]);
                list[team-1].lastSubmit = i;
                list[team-1].submitNum += 1;
            }
            for (Team team : list) {
                for (int i : team.score) {
                    team.sum += i;
                }
            }
            Arrays.sort(list, Comparator
                    .<Team>comparingInt(e -> e.sum).reversed()
                    .thenComparingInt(e -> e.submitNum)
                    .thenComparingInt(e -> e.lastSubmit));
            for(int i = 0; i<n; i++){
                if(list[i].id == t) System.out.println(i+1);
            }
        }
    }
    public static class Team {
        int id; //팀Id
        int[] score; //각 문제에 대한 점수
        int submitNum; //제출 횟수
        int lastSubmit; //제출 시간
        int sum;
    }
}
