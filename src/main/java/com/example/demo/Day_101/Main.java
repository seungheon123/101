package com.example.demo.Day_101;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        String[] keymap = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        String[] targets = {"ok", "test", "test", "test", "test", "test", "test", "test"};
        int[] result = solution(keymap, targets);
        for(int i : result){
            System.out.println(i);
        }
    }
    public static int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        HashMap<Character, Integer> map = new HashMap<>();

        for(String key: keymap){
            for(int i = 0; i<key.length(); i++){
                char ch = key.charAt(i);
                if(map.containsKey(ch)){
                    int curr = map.get(ch);
                    if(curr > i+1){
                        map.replace(ch,i+1);
                    }
                } else map.put(ch,i+1);
            }
        }
        for(int i = 0; i<targets.length; i++){
            String target = targets[i];
            int count = 0;
            for(int j = 0; j<target.length(); j++){
                char ch = target.charAt(j);
                if(map.containsKey(ch)){
                    count +=map.get(ch);
                } else{
                    count = -1;
                    break;
                }
            }
            answer[i] = count;
        }

        return answer;
    }
}
