package com.example.demo.Day_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        int mode;
        int[] arr = new int[N];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i<N; i++){
            int x = Integer.parseInt(br.readLine());
            arr[i] = x;
            sum+=x;
        }
        Arrays.sort(arr);

        for(int i = 0; i<N; i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int compare = map.get(o2).compareTo(map.get(o1));
                if(compare==0){
                    return o1.compareTo(o2);
                }else return compare;
            }
        });

        double average = Math.round((double)sum/N);
        int mid = arr[N/2];
        int mod;
        int prev = map.get(list.get(0));

        if(list.size()==1) mod = list.get(0);
        else if(map.get(list.get(0)).equals(map.get(list.get(1)))){
            mod = list.get(1);
        }else mod = list.get(0);
        int len = arr[N-1] - arr[0];
        sb.append((int)average).append("\n").append(mid).append("\n").append(mod).append("\n").append(len);

        System.out.println(sb);
    }
}
