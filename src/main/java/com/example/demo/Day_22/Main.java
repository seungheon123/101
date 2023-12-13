package com.example.demo.Day_22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String,Integer> map = new HashMap<>();
        String str = br.readLine();
        int length = str.length();
        for(int i = 0; i<length; i++){
            String key = Character.toString(str.charAt(i));
            map.put(key,map.getOrDefault(key,0)+1);
            for(int j = i+1; j<length; j++){
                key += Character.toString(str.charAt(j));
                map.put(key,map.getOrDefault(key,0)+1);
            }
        }
        System.out.println(map.size());

    }
}
