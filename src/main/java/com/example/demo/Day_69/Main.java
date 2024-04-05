package com.example.demo.Day_69;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Person[] people = new Person[N];
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            people[i] = new Person(age, name);
        }
//        Arrays.sort(people, new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                int compare = Integer.compare(o1.age, o2.age);
//                if(compare == 0) return o1.name.compareTo(o2.name);
//                return compare;
//            }
//        });
        Arrays.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.age - o2.age;
            }
        });

        for(Person person : people){
            sb.append(person.age + " "+person.name).append("\n");
        }
        System.out.println(sb);

    }

    static class Person{
        int age;
        String name;

        Person(int age, String name){
            this.age = age;
            this.name = name;
        }
    }
}
