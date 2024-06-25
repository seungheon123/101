package com.example.demo.Day_99;

public class Main {
    public static void main(String[] args) {
        int k = 300;
        int[] limits = {2000, 1000, 3000, 200, 600, 500};
        int[][] sockets =  {{2, 3, -1 ,-1 ,-1}, {4, 0, -1, -1, 6}, {5, 0, 0, 0, 0},
                {-1, 0, 0, 0, 0}, {-1, -1, -1, -1, -1}, {-1, -1, 0, 0, 0}};
        System.out.println(solution(k, limits, sockets));
    }

    public static int solution(int k, int[] limits, int[][] sockets) {
        int answer = 0;
        int[] powerUsage = new int[limits.length];
        for(int i = sockets.length-1; i>=0; i--){
            int[] socket = sockets[i];
            int power = 0;
            for(int num : socket){
                if(num == -1){
                    power+=k;
                }else if(num > 1){
                    power += powerUsage[num-1];
                }
            }

            if(power > limits[i]){
                int over  = power - limits[i];
                int num = (int) Math.ceil((double) over / k);
                answer += num;
                powerUsage[i] = power - (num * k);
            } else {
                powerUsage[i] = power;
            }

        }
        return answer;
    }
}
