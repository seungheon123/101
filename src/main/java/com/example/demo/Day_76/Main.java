package com.example.demo.Day_76;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {0,0,0};
        String solution = solution(arr);
        System.out.println(solution);

    }

        public static String solution(int[] numbers) {
            StringBuilder answer = new StringBuilder();
            int len = numbers.length;
            String[] arr = new String[len];
            for(int i = 0; i<len; i++){
                arr[i] = String.valueOf(numbers[i]);
            }
            Arrays.sort(arr,(o1, o2)->(o2+o1).compareTo(o1+o2));

            if(arr[0].equals("0")) return "0";
            for(int i = 0; i<len; i++){
                answer.append(arr[i]);
            }
            return answer.toString();

        }
}
