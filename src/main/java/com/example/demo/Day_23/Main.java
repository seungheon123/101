package com.example.demo.Day_23;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static Queue<Integer> queue = new LinkedList<>();
    public static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int count = 1;
        while(st.hasMoreTokens()){
            queue.add(Integer.parseInt(st.nextToken()));
        }

        while(!queue.isEmpty()){
            if(queue.peek()==count){
                queue.poll();
                count++;
            }else if(!stack.isEmpty() && stack.peek()==count){
                stack.pop();
                count++;
            }else{
                stack.push(queue.poll());
            }
        }
        while(!stack.isEmpty()){
            if(stack.peek() == count){
                stack.pop();
                count++;
            }else{
                System.out.println("Sad");
                return;
            }
        }
        System.out.println("Nice");
    }
}
