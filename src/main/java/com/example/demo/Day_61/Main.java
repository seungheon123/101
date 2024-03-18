package com.example.demo.Day_61;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static char c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int B = 0;
        int R = 0;
        c = str.charAt(0);
        if(c == 'B') B++;
        else R++;
        for(int i = 1; i<N; i++){
            if(c == str.charAt(i)) continue;
            else {
                if(str.charAt(i)=='B') B++;
                else R++;
                c = str.charAt(i);
            }
        }
        int min = Math.min(R,B);
        System.out.println(1+min);



    }
}
