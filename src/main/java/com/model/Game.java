package com.model;

import java.util.*;

public class Game {
    private Set<Integer> number = new HashSet<>();

    List<String>results = new ArrayList<>();
    private String num;

    public Game() {
        while (number.size() < 4) {
            number.add(new Random().nextInt(9 + 1));
        }
        num = generateNum();
    }

    public Set<Integer> getNumber() {
        return number;
    }

    public boolean check(int[]answer) {
        Set<Integer>bulls = new HashSet<>();
        Set<Integer>cows = new HashSet<>();
        Iterator<Integer> iterator = number.iterator();
        StringBuilder ans = new StringBuilder();
        for (int num  : answer) {

            if (iterator.next() == num) {
                bulls.add(num);
            } else if (number.contains(num) && !bulls.contains(num)) {
                cows.add(num);
            }
            ans.append(num);
        }
        results.add(ans.toString()+" "+bulls.size()+"Б "+cows.size()+"K");
        return ans.toString().equals(num);
    }


    public List<String> getResults() {
        return results;
    }

    public String generateNum(){
        StringBuilder builder = new StringBuilder("");
        for (Integer integer : number) {
            builder.append(integer);
        }
        System.out.println(builder.toString());
        return builder.toString();
    }

    public String getNum() {
        return num;
    }
}
