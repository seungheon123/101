package com.example.demo.Day_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static Stack<Character> stack = new Stack<>();
    public static int i;
    public static String s;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s = br.readLine();
        while(i<s.length()){
            if(s.charAt(i)=='<'){
                insert();
            }
            else{
                insertStack();
            }
        }
        System.out.println(sb);
    }


    public static void insert(){
        while(true){
            if(s.charAt(i)=='>'){
                sb.append(s.charAt(i));
                i++;
                break;
            }
            else{
                sb.append(s.charAt(i));
                i++;
            }
        }
    }

    public static void insertStack(){
        boolean space = false;
        while(i<s.length()){
            if(s.charAt(i)=='<'){
                break;
            }
            else if(s.charAt(i)==' '){
                space = true;
                i++;
                break;
            }
            else{
                stack.push(s.charAt(i));
                i++;
            }
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        if(space) sb.append(' ');
    }


}
