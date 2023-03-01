package org.leetcode;

import java.util.Map;

/**
 * packageName    : org.leetcode
 * fileName       : RomanToInteger
 * author         : men16
 * date           : 2023-03-01
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-03-01        men16       최초 생성
 */
public class RomanToInteger {
    Map<Character, Integer> romanMap = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000
    );
    public int romanToInt(String s) {
        char [] chars = s.toCharArray();
        int sum = 0;
        int len = chars.length;
        for(int i = 0; i < len; i++) {
            int num = romanMap.get(chars[i]);
            if(chars[i] == 'I' && i != len - 1) {
                if(chars[i + 1] == 'V') {
                    num = 4;
                    if(i != len - 1) i++;
                } else if(chars[i + 1] == 'X') {
                    num = 9;
                    if(i != len - 1) i++;
                }
            } else if(chars[i] == 'X' && i != len - 1) {
                if(chars[i + 1] == 'L') {
                    num = 40;
                    if(i != len - 1) i++;
                } else if(chars[i + 1] == 'C') {
                    num = 90;
                    if(i != len - 1) i++;
                }
            } else if(chars[i] == 'C' && i != len - 1) {
                if(chars[i + 1] == 'D') {
                    num = 400;
                    if(i != len - 1) i++;
                } else if(chars[i + 1] == 'M') {
                    num = 900;
                    if(i != len - 1) i++;
                }
            }
            sum += num;
        }
        return sum;
    }

    public int romanToInt_chatGPT(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int value = romanMap.get(s.charAt(i));
            if (i < s.length() - 1 && value < romanMap.get(s.charAt(i + 1))) {
                result -= value;
            } else {
                result += value;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        RomanToInteger romanToInteger = new RomanToInteger();
        String s = "MCMXCIV";
        System.out.println(romanToInteger.romanToInt_chatGPT(s));
    }
}

