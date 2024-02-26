package com.example.demo.Day_49;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static int[] arr = new int[6];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int maxWidth = 0;
        int maxHeight = 0;
        int widthIndex = -1;
        int heightIndex = -1;
        int K = Integer.parseInt(st.nextToken());
        for(int i=0; i<6; i++){
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            arr[i] = dist;
            if(dir == 3 | dir == 4) {
                if(dist > maxHeight) {
                    maxHeight = dist;
                    heightIndex = i;
                }
            } else {
                if(dist > maxWidth) {
                    maxWidth = dist;
                    widthIndex = i;
                }
            }
        }
        int tempHeight = calculate(heightIndex);
        int tempWidth = calculate(widthIndex);
        int result = (maxHeight * maxWidth) - (tempHeight * tempWidth);
        result *= K;
        System.out.println(result);

    }

    static int calculate(int index) {
        int result = 0;
        if(index -1 == -1) {
            result = Math.abs(arr[5] - arr[index+1]);
        } else if(index + 1 == 6) {
            result = Math.abs(arr[0] - arr[index-1]);
        } else {
            result = Math.abs(arr[index-1] - arr[index+1]);
        }
        return result;
    }

}
