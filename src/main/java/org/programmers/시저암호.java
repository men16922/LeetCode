package org.programmers;

public class 시저암호 {
    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c)) { // 소문자인 경우
                char encrypted = (char) ((c - 'a' + n) % 26 + 'a');
                answer.append(encrypted);
            } else if (Character.isUpperCase(c)) { // 대문자인 경우
                char encrypted = (char) ((c - 'A' + n) % 26 + 'A');
                answer.append(encrypted);
            } else { // 알파벳이 아닌 경우
                answer.append(c);
            }
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        String s = "abCEDGQazx";
        int n = 25;
        시저암호 시저암호 = new 시저암호();
        System.out.println(시저암호.solution(s, n));
    }
}
