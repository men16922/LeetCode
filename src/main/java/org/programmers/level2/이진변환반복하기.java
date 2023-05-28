package org.programmers.level2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 이진변환반복하기 {
    public int[] solution(String s) {
        Pattern pattern = Pattern.compile("0");
        int zeroCount = 0;
        int binaryCount = 0;
        while (!s.equals("1")) {
            Matcher matcher = pattern.matcher(s);
            while (matcher.find()) {
                zeroCount++;
            }
            s = Integer.toBinaryString(s.replaceAll("0", "").length());
            binaryCount++;
        }
        int[] answer = {binaryCount, zeroCount};
        return answer;
    }

    public static void main(String[] args) {
        String s = "110010101001";
        이진변환반복하기 이진변환반복하기 = new 이진변환반복하기();
        System.out.println(이진변환반복하기.solution(s));
    }
}
