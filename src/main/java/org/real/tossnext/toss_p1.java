package org.real.tossnext;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class toss_p1 {

    public int solution(String s, int N) {
        String answer = "-1";
        int len = s.length();
        List<String> wordList = new ArrayList<>();

        for (int i = 0; i <= len - N; i++) {
            wordList.add(s.substring(i, i + N));
        }

        return wordList.stream()
                .filter(substring -> isHandsome(substring, N))
                .mapToInt(Integer::parseInt)
                .max()
                .orElse(Integer.parseInt(answer));
    }
    public boolean isHandsome(String s, int N) {
        if (s.length() != N) {
            return false;
        }
        List<Integer> digits = IntStream.rangeClosed(1, N)
                .boxed()
                .collect(Collectors.toList());

        for (int i = 0; i < N; i++) {
            int digit = Character.getNumericValue(s.charAt(i));
            if (!digits.contains(digit)) {
                return false;
            }
            digits.remove((Integer) digit);
        }

        return true;
    }

    public static void main(String[] args) {
        toss_p1 toss_p1 = new toss_p1();
        String s = "313253123";
        int N = 3;
        System.out.println(toss_p1.solution(s, N));
    }
}
