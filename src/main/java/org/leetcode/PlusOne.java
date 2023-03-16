package org.leetcode;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        double x = (double) Math.pow(10, len - 1);
        double result = 0;
        for(int i = 0; i < len; i++) {
            result += digits[i] * x;
            x = x / 10;
        }

        result = result + 1;
        BigDecimal bigDecimal = BigDecimal.valueOf(Double.valueOf(result));
        BigInteger bigInteger = BigInteger.valueOf(bigDecimal.longValue());
        String str = String.valueOf(bigInteger);
        char [] chars = str.toCharArray();
        List<Integer> resultList = new ArrayList<>();
        for(char ch : chars) {
            resultList.add(Character.getNumericValue(ch));
        }
        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] plusOne_chatGPT(int[] digits) {
        // 배열의 가장 오른쪽 숫자부터 처리하기 위해 뒤에서부터 반복문 실행
        for (int i = digits.length - 1; i >= 0; i--) {
            // 현재 자릿수에 1을 더함
            digits[i]++;
            System.out.println(digits[i]);
            // 자릿수가 10이 되지 않으면 더 이상 자릿수 올림이 발생하지 않음
            if (digits[i] < 10) {
                return digits;
            }
            // 자릿수가 10이 되면 1을 다음 자리수에 올려줌
            digits[i] = 0;
        }
        // 반복문이 모두 실행된 경우 가장 왼쪽 자릿수까지 올림이 발생하므로
        // 새로운 배열을 생성하여 가장 왼쪽에 1을 추가해줌
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }

    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        int [] digits = {1,2,3,4};
        plusOne.plusOne_chatGPT(digits);
//        Arrays.stream(plusOne.plusOne_chatGPT(digits)).sequential().forEach(item -> System.out.println(item));
    }
}
