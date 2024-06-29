package com.example.demo.Day_100;

public class Main {
    public static void main(String[] args) {
        String[] wallpaper = {"#.....#",
                "#.....#",
                "#######",
                "#.....#",
                "#.....#"};
        int[] result = solution(wallpaper);
        for(int i : result){
            System.out.println(i);
        }

    }

    public static int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        int h = wallpaper.length;
        int w = wallpaper[0].length();
        int lux = 50;
        int luy = 50;
        int rdx = 0;
        int rdy = 0;
        for(int i = 0; i<h; i++){
            for(int j = 0; j<w; j++){
                if(wallpaper[i].charAt(j)=='#'){
                    if(i<lux){
                        lux = i;
                    }
                    if(j<luy){
                        luy = j;
                    }
                    if(i+1>rdx){
                        rdx = i+1;
                    }
                    if(j+1>rdy){
                        rdy = j+1;
                    }
                }
            }
        }
        answer[0] = lux;
        answer[1] = luy;
        answer[2] = rdx;
        answer[3] = rdy;
        return answer;
    }
}
