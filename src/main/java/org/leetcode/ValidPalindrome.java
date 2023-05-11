package org.leetcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * packageName    : org.leetcode
 * fileName       : ValidPalindrome
 * author         : men16
 * date           : 2023-05-06
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-05-06        men16       최초 생성
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        Pattern validPattern = Pattern.compile("[\\p{Alnum}&&[^_]]");
        Matcher matcher = validPattern.matcher(s);

        StringBuilder stringBuilder = new StringBuilder();
        while (matcher.find()) {
            stringBuilder.append(matcher.group());
        }

        String origin = stringBuilder.toString().toLowerCase();
        String reverse = stringBuilder.reverse().toString().toLowerCase();
        System.out.println(origin);
        if (origin.equals(reverse)) {
            return true;
        }
        return false;
    }

    public static boolean isPalindrome_chatGPT(String s) {
        // 문자열을 모두 소문자로 변환하고, 알파벳과 숫자만 남기도록 정제합니다.
        String cleaned = s.toLowerCase().replaceAll("[^a-z0-9]", "");

        int left = 0;
        int right = cleaned.length() - 1;

        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        String s = "ab_a";
        System.out.println(validPalindrome.isPalindrome(s));
    }
}

