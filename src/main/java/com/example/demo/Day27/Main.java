package com.example.demo.Day27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        char[] str = br.readLine().toCharArray();
        for (char c : str) {
            if (c >= '0') {
                stack.push((int) (c - '0'));
            } else {
                int a = stack.pop();
                int b = stack.pop();
                switch (c) {
                    case '+':
                        stack.push(a + b);
                        break;
                    case '-':
                        stack.push(b - a);
                        break;
                    case '*':
                        stack.push(a * b);
                        break;
                    case '/':
                        stack.push(b / a);
                        break;
                }
            }
        }
        System.out.println(stack.pop());
    }
}
