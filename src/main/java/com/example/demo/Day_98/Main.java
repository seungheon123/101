package com.example.demo.Day_98;

public class Main {
    public static void main(String[] args) {
        System.out.println(solution(3, 20, 4));
    }
    public static long solution(int price, int money, int count) {
        long answer = 0;
        long cost = 0;
        for(int i = 1; i<=count; i++){
            cost += (long) i * price;
        }
        answer = cost >= money ? cost - money : 0;
        return answer;
    }
}
