package com.example.demo.Day26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int res = 0;
        int N = Integer.parseInt(br.readLine());
        Stack<Assignment> stack = new Stack<>();
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            if(Integer.parseInt(st.nextToken())==1){
                int score = Integer.parseInt(st.nextToken());
                int minute = Integer.parseInt(st.nextToken());
                if(minute == 1){
                    res+=score;
                }else{
                    stack.push(new Assignment(score,minute-1));
                }
            }else{
                if(!stack.isEmpty()){
                    Assignment temp = stack.pop();
                    temp.minute--;
                    if(temp.minute==0){
                        res+=temp.score;
                    }else{
                        stack.push(temp);
                    }
                }
            }
        }
        System.out.println(res);
    }

    static class Assignment{
        int score;
        int minute;

        public Assignment(int score, int minute){
            this.score = score;
            this.minute = minute;
        }
    }
}
