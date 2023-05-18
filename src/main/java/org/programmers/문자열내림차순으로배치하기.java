package org.programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class 문자열내림차순으로배치하기 {

    public String solution(String s) {
        return s.chars().mapToObj(i -> (char) i).sorted(Comparator.reverseOrder()).map(c -> c.toString()).collect(Collectors.joining());
    }
    public String reverseStr(String str){
        char[] sol = str.toCharArray();
        Arrays.sort(sol);
        return new StringBuilder(new String(sol)).reverse().toString();
    }

    public static void main(String[] args) {
        String s = "Zbcdefg";
        문자열내림차순으로배치하기 문자열내림차순으로배치하기 = new 문자열내림차순으로배치하기();
        System.out.println(문자열내림차순으로배치하기.solution(s));
    }
}
