package com.example.demo.Day13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int res = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        int len = str.length();
        for(int i = 0; i<len; i++){
            char ch = str.charAt(i);
            if(ch == 'c' && i<len-1){
                if(str.charAt(i+1)=='-' || str.charAt(i+1)=='=') {
                    i++;
                }
            }
            else if(ch=='d'&&i<len-1){
                if(str.charAt(i + 1) == '-') {	// d- 일 경우
                    i++;
                }
                else if(str.charAt(i + 1) == 'z' && i < len - 2) {
                    if(str.charAt(i + 2) == '=') {	// dz= 일 경우
                        i += 2;
                    }
                }
            }
            else if((ch == 'l' || ch == 'n') && i < len - 1) {
                if(str.charAt(i + 1) == 'j') {    // lj 또는 nj 일 경우
                    i++;
                }
            }
            else if((ch == 's' || ch == 'z') && i < len - 1) {
                if(str.charAt(i + 1) == '=') {	// s= 또는z= 일 경우
                    i++;
                }
            }
            res++;
        }
        System.out.println(res);
    }
}
