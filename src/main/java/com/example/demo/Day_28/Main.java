package com.example.demo.Day_28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] str = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        int res = 0;
        for(int i = 0; i<N; i++){
            if(str[i]=='R'){
                if(!stack.isEmpty()){
                    stack.pop();
                    res++;
                }else break;
            }
            else if(str[i]=='K'){
                if(!stack2.isEmpty()){
                    stack2.pop();
                    res++;
                }else break;
            }
            else if(str[i]=='L'){
                stack.push(str[i]);
            }
            else if(str[i]=='S'){
                stack2.push(str[i]);
            }
            else res++;
        }

        System.out.println(res);
    }
}
