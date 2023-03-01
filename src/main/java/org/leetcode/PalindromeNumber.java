package org.leetcode;

/**
 * packageName    : org.leetcode
 * fileName       : PalindromeNumber
 * author         : men16
 * date           : 2023-03-01
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-03-01        men16       최초 생성
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        String origin = String.valueOf(x);
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(x));
        String reverse = stringBuilder.reverse().toString();
        if(origin.equals(reverse)) {
            return true;
        }
        return false;
    }

    public boolean isPalindrome_chatGPT(int x) {
        String s = Integer.toString(x);
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        int x = 121;
        System.out.println(palindromeNumber.isPalindrome(x));
    }
}

