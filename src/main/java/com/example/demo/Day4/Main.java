package com.example.demo.Day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {

    public static Stack<Character> leftStack = new Stack<>();
    public static Stack<Character>rightStack = new Stack<>();
    public static String n;
    public static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        n = br.readLine();

        for(int i =0; i<n.length(); i++){
            leftStack.push(n.charAt(i));
        }
        int m = Integer.parseInt(br.readLine());
        while(m-->0){
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()){
                case "P":
                    leftStack.push(st.nextToken().charAt(0));
                    break;
                case "L":
                    if(!leftStack.isEmpty()) rightStack.push(leftStack.pop());
                    break;
                case "D":
                    if(!rightStack.isEmpty())leftStack.push(rightStack.pop());
                    break;
                case "B":
                    if(!leftStack.isEmpty()) leftStack.pop();
                    break;
            }
        }
        while(!leftStack.isEmpty()){
            rightStack.push(leftStack.pop());
        }
        while(!rightStack.isEmpty()){
            sb.append(rightStack.pop());
        }
        System.out.println(sb);

    }
}

/*
public class Main {

    public static LinkedList<Character> list = new LinkedList<>();
    public static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        String n = br.readLine();
        int length = n.length();
        int cursor = length;
        for(int i = 0; i<length; i++){
            list.add(n.charAt(i));
        }
        m = Integer.parseInt(br.readLine());
        while(m>0){
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()){
                case "P":
                    list.add(cursor,st.nextToken().charAt(0));
                    cursor++;
                    break;
                case "L":
                    if(cursor == 0) break;
                    else cursor--;
                    break;
                case "D":
                    if(cursor == list.size()) break;
                    else cursor++;
                    break;
                case "B":
                    if(cursor == 0) break;
                    else{
                        list.remove(cursor-1);
                        cursor--;
                    }
                    break;
            }
            m--;
        }
        for (Character character : list) {
            sb.append(character);
        }
        System.out.println(sb);

    }
}
*/
