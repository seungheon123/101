package com.example.demo.Day_85;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        Set<Integer> set = new HashSet<>();
        List<Integer> orderList = new ArrayList<>(); // set에 값이 추가된 순서를 저장하는 리스트
        set.add(N);
        orderList.add(N); // 첫 번째로 추가된 값이므로 순서를 1로 기록
        set.add(N);
        int count = 0;
        int n = N;
        while(true){
            n = (n*N)%P;
            if(set.contains(n)) break;
            set.add(n);
            orderList.add(n);
            count++;
        }
        int answer =  count - orderList.indexOf(n)+1;
        System.out.println(answer);
    }
}
