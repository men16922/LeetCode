package org.programmers;

import java.math.BigInteger;
import java.util.stream.LongStream;

public class 크기가작은부분문자열 {

    public int solution(String t, String p) {
        int count = 0; // 나타내는 수가 p보다 작거나 같은 부분문자열의 개수

        int tLen = t.length(); // t의 길이
        int pLen = p.length(); // p의 길이

        BigInteger pNum = new BigInteger(p); // p를 BigInteger로 변환

        // t의 길이만큼 반복하면서 길이가 p와 같은 부분문자열을 확인
        for (int i = 0; i <= tLen - pLen; i++) {
            String subStr = t.substring(i, i + pLen); // 부분문자열 추출

            BigInteger subNum = new BigInteger(subStr); // 부분문자열을 BigInteger로 변환

            // 나타내는 수가 p보다 작거나 같으면 count 증가
            if (subNum.compareTo(pNum) <= 0) {
                count++;
            }
        }

        return count;
    }

    public int solution_other(String t, String p) {
        long targetNumber = Long.parseLong(p);
        int targetNumberLength = p.length();

        return (int) LongStream.range(0L, t.length() - targetNumberLength + 1L)
                .mapToObj(i -> t.substring((int) i, (int) i + targetNumberLength))
                .mapToLong(Long::parseLong)
                .filter(number -> number <= targetNumber)
                .count();
    }

    public static void main(String[] args) {
        String t = "1";
        String p = "1";
        크기가작은부분문자열 크기가작은부분문자열 = new 크기가작은부분문자열();
        System.out.println(크기가작은부분문자열.solution(t, p));
    }
}
