package com.example.demo.Day_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static int N;
    public static String M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        while(N-->0){
            StringBuilder sb = new StringBuilder();
            Stack<Character> leftStack = new Stack<Character>();
            Stack<Character> rightStack = new Stack<Character>();
            String str = br.readLine();
            for(int i =0; i<str.length(); i++){
                char token = str.charAt(i);
                switch (token) {
                    case '<':
                        if (!leftStack.isEmpty()) rightStack.push(leftStack.pop());
                        break;
                    case '>':
                        if (!rightStack.isEmpty()) leftStack.push(rightStack.pop());
                        break;
                    case '-':
                        if (!leftStack.isEmpty()) leftStack.pop();
                        break;
                    default:
                        leftStack.push(token);
                        break;

                }
            }
            while(!leftStack.isEmpty()){
                rightStack.push(leftStack.pop());
            }
            while (!rightStack.isEmpty()){
                sb.append(rightStack.pop());
            }
            System.out.println(sb);
        }

    }
}
