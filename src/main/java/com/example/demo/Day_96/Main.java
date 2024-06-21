package com.example.demo.Day_96;

public class Main {
    public static void main(String[] args) {
        System.out.println(solution(5, 2, 6));
    }
    public static int solution(int a, int b, int n) {
        int answer = 0;
        while(n>=a){
            int newCola = (n / a) * b;
            int left = n % a;
            n = left + newCola;
            answer += newCola;
        }

        return answer;
    }
}
