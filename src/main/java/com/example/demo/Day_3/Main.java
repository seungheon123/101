package com.example.demo.Day_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        while(n>0){
            m = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            for(int i = 0; i<m; i++){
                st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String type = st.nextToken();
                map.put(type,map.getOrDefault(type,0)+1);
            }
            int result = 1;
            for (Integer value : map.values()) {
                result *=value +1;
            }
            System.out.println(result-1);

            n--;
        }

    }
}
