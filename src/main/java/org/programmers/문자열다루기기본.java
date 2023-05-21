package org.programmers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 문자열다루기기본 {
    public boolean solution(String s) {
        boolean answer = false;
        Pattern pattern = Pattern.compile("[^\\d]");
        Matcher matcher = pattern.matcher(s);
        if (s.length() == 4 || s.length() == 6) {
            while (matcher.find()) {
                return false;
            }
            return true;
        }
        return answer;
    }

    public boolean solution_other(String s) {
        return s.matches("\\d{4}|\\d{6}");
    }

    public static void main(String[] args) {
        문자열다루기기본 문자열다루기기본 = new 문자열다루기기본();
        System.out.println(문자열다루기기본.solution("1234"));
    }
}
