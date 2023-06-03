package org.programmers;

import java.util.Arrays;

public class 문자열내마음대로정렬하기 {

    public String[] solution(String[] strings, int n) {
        return Arrays.stream(strings).sorted((o1, o2) -> {
            int compare = Character.compare(o1.charAt(n), o2.charAt(n));
            if (compare == 0) compare = o1.compareTo(o2);
            return compare;
        }).toArray(String[]::new);
    }

    public static void main(String[] args) {
        문자열내마음대로정렬하기 문자열내마음대로정렬하기 = new 문자열내마음대로정렬하기();
        String [] strings = {"abce", "abcd", "cdx"};
        int n = 2;
        for (String s : 문자열내마음대로정렬하기.solution(strings, n)) {
            System.out.println(s);
        }
    }
}
