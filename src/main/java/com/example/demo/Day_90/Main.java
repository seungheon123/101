package com.example.demo.Day_90;

public class Main {
    public static void main(String[] args) {
        solution(5,3,2);

    }
        public static int solution(int number, int limit, int power) {
            int answer = 0;
            for(int i = 1; i<=number; i++){
                int k = calculate(i);
                if(k>limit) answer+=power;
                else answer+=k;
            }
            return answer;
        }

        public static int calculate(int num){
            int count = 0;
            for(int i = 1; i*i<=num; i++){
                if(i*i == num) count++;
                else if(num%i==0) count+=2;
            }
            return count;
        }
}
