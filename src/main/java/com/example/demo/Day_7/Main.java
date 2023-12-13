package com.example.demo.Day_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        int start = 0;
        while(n-->0){
            int value = Integer.parseInt(br.readLine());
            if(value>start){
                for(int i = start+1; i<value+1; i++){
                    stack.push(i);
                    sb.append("+").append("\n");
                }
                start = value;
            }
            else if(stack.peek()!=value){
                sb.setLength(0);
                sb.append("NO");
                break;
            }
            stack.pop();
            sb.append("-").append("\n");
        }
        System.out.println(sb);

    }

}
