package org.programmers.level2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 이진변환 {

    public int[] solution(String s) {
        Pattern pattern = Pattern.compile("[0]");
        int zeroCount = 0;
        int convertCount = 0;
        while (!s.equals("1")) {
            Matcher matcher = pattern.matcher(s);
            while (matcher.find()) {
                zeroCount++;
            }
            s = Integer.toBinaryString(s.replaceAll("0", "").length());
            convertCount++;
        }
        int[] answer = {convertCount, zeroCount};
        return answer;
    }

    public static void main(String[] args) {
        이진변환 이진변환 = new 이진변환();
        String s = "110010101001";
        System.out.println(이진변환.solution(s));
    }
}
