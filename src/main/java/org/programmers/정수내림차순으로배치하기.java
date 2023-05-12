package org.programmers;

import java.util.Arrays;
import java.util.Collections;

public class 정수내림차순으로배치하기 {

    public long solution(long n) {
        char [] charArray = Long.toString(n).toCharArray();
        int [] intArray = new int [charArray.length];
        Arrays.setAll(intArray, i -> charArray[i] - '0');
        intArray = Arrays.stream(intArray)
                .boxed().sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue).toArray();
        return Long.parseLong(Arrays.toString(intArray).replaceAll("[^\\d]", ""));
    }

    public long solution_other(long n) {
        String[] list = String.valueOf(n).split("");
        Arrays.sort(list);

        StringBuilder sb = new StringBuilder();
        for (String aList : list) sb.append(aList);

        return Long.parseLong(sb.reverse().toString());
    }

    public static void main(String[] args) {
        정수내림차순으로배치하기 정수내림차순으로배치하기 = new 정수내림차순으로배치하기();
        System.out.println(정수내림차순으로배치하기.solution(118372));
    }
}
