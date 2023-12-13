package com.example.demo.Day_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int res = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        while (N-->0){
            String str = br.readLine();
            if(check(str)) res++;
        }
        System.out.println(res);

    }

    public static boolean check(String str){
        boolean[] alpha = new boolean[26];
        int prev = 0;
        for(int i =0; i<str.length(); i++){
            int now = str.charAt(i);
            if(prev!=now){
                if(!alpha[now-'a']){
                    alpha[now-'a']=true;
                    prev = now;
                }else return false;
            }else continue;
        }
        return true;
    }
}
