package org.programmers;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 문자열내p와y의개수 {

    boolean solution(String s) {
        s = s.toLowerCase(Locale.ROOT);
        Pattern pattern = Pattern.compile("p");
        Matcher matcher = pattern.matcher(s);
        int pCount = 0;
        while (matcher.find()) {
            pCount++;
        }

        pattern = Pattern.compile("y");
        matcher = pattern.matcher(s);
        int yCount = 0;
        while (matcher.find()) {
            yCount++;
        }
        return yCount == pCount;
    }

    boolean solution_other(String s) {
        s = s.toUpperCase();

        return s.chars().filter( e -> 'P'== e).count() == s.chars().filter( e -> 'Y'== e).count();
    }

    public static void main(String[] args) {
        String s = "pPoooyY";
        문자열내p와y의개수 문자열내p와y의개수 = new 문자열내p와y의개수();
        System.out.println(문자열내p와y의개수.solution(s));
    }
}
