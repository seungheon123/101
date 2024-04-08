package com.example.demo.Day_73;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int N;
    public static List<Integer> positive = new LinkedList<>();
    public static List<Integer> negative = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            if(num>0) positive.add(num);
            else negative.add(num);
        }

        positive.sort(Collections.reverseOrder());
        Collections.sort(negative);

        int sum = 0;
        int i = 0;
        while(i<positive.size()){
            if(i+1<positive.size() && positive.get(i)!=1 && positive.get(i+1)!=1){
                sum +=positive.get(i++) * positive.get(i++);
            } else sum +=positive.get(i++);
        }

        i = 0;
        while(i<negative.size()){
            if(i+1<negative.size()){
                sum+=negative.get(i++) * negative.get(i++);
            } else sum +=negative.get(i++);
        }

        System.out.println(sum);

    }
}
