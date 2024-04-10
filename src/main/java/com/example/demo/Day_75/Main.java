package com.example.demo.Day_75;
import java.io.*;
import java.util.*;
public class Main {
    public static int cash, J, S;
    public static int[] MachineDuck = new int[14];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        cash = Integer.parseInt(br.readLine());
        Person J = new Person(cash);
        Person S = new Person(cash);
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i<14; i++){
            MachineDuck[i] = Integer.parseInt(st.nextToken());
        }

        int curr = MachineDuck[0];
        if(J.getCash()>=curr) {
            int amount = J.getCash() / curr;
            int left = J.getCash() - (curr * amount);
            J.setCash(left);
            J.setStock(amount);
        }
        int prev = curr;
        int inc = 1;
        int dec = 1;

        for(int i = 1; i<14; i++){
            curr = MachineDuck[i];

            if(J.getCash()>=curr) {
                int amount = J.getCash() / curr;
                int left = J.getCash() - (curr * amount);
                J.setCash(left);
                J.setStock(amount);
            }
            if(curr < prev) {
                dec++;
                inc = 0;
            }
            if (curr > prev) {
                inc++;
                dec = 0;
            }

            if(dec == 3 && S.getCash()>=curr) {
                int amount = S.getCash() / curr;
                int left = S.getCash() - (curr * amount);
                S.setCash(left);
                S.setStock(amount);
                dec = 0;
            }
            if(inc == 3 && S.hasStock()) {
                int sellPrice = S.getStock() * curr;
                S.addCash(sellPrice);
                S.setStock(0);
                inc = 0;
            }
            prev = curr;
        }

        int sellPrice = J.getStock() * MachineDuck[13];
        J.addCash(sellPrice);

        sellPrice = S.getStock() * MachineDuck[13];
        S.addCash(sellPrice);


        if(S.getCash() > J.getCash()) System.out.println("TIMING");
        else if(S.getCash()<J.getCash()) System.out.println("BNP");
        else System.out.println("SAMESAME");


    }

    public static class Person{
        int cash;
        int stock;

        Person(int cash){
            this.cash = cash;
            this.stock = 0;
        }

        public boolean hasStock(){
            return stock>0;
        }

        public int getCash(){
            return cash;
        }

        public int getStock(){
            return stock;
        }

        public void setCash(int cash) {
            this.cash = cash;
        }

        public void setStock(int stock){
            this.stock = stock;
        }

        public void addCash(int cash){
            this.cash += cash;
        }
    }
}
