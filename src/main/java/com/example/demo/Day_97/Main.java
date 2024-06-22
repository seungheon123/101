package com.example.demo.Day_97;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        System.out.println(solution(sizes));
    }
    public static int solution(int[][] sizes) {
        int answer = 0;
        int width = 0;
        int height = 0;
        for(int[] size : sizes){
            Arrays.sort(size);
            width = Math.max(width, size[0]);
            height = Math.max(height, size[1]);
        }
        answer = width * height;
        return answer;
    }
}
