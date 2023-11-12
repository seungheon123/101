package com.example.demo.Day1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static int[] stack;
    public static int N;
    public static int size = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        stack = new int[N];

        while (N>0){
            st = new StringTokenizer(br.readLine());
            int n = 0;
            switch (st.nextToken()){
                case "push":
                    push(Integer.parseInt(st.nextToken()));
                    break;
                case  "pop":
                    n = pop();
                    System.out.println(n);
                    break;
                case "size":
                    n = size();
                    System.out.println(n);
                    break;
                case "empty":
                    n = empty();
                    System.out.println(n);
                    break;
                case "top":
                    n = top();
                    System.out.println(n);
                    break;
            }
            N--;
        }
    }


    public static void push(int N){
        stack[size] = N;
        size++;
    }

    public static int pop(){
        if(size == 0) return -1;
        int n = stack[size-1];
        size--;
        return n;
    }

    public static int top(){
        if(size == 0) return -1;
        return stack[size-1];
    }

    public static int size(){
        return size;
    }

    public static int empty(){
        if(size == 0) return 1;
        return 0;
    }

}
