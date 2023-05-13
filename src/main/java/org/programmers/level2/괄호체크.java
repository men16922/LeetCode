package org.programmers.level2;

import java.util.Stack;

public class 괄호체크 {
    public String solution(String p) {
        if (p.isEmpty()) { // 입력이 빈 문자열인 경우
            return "";
        }

        int splitIndex = getSplitIndex(p); // 문자열을 균형잡힌 괄호 문자열로 분리할 인덱스를 찾음
        String u = p.substring(0, splitIndex + 1); // 균형잡힌 괄호 문자열 u
        String v = p.substring(splitIndex + 1); // 나머지 문자열 v

        if (isCorrect(u)) { // u가 올바른 괄호 문자열인 경우
            return u + solution(v); // u 뒤에 재귀적으로 solution 수행한 결과 문자열을 이어 붙임
        } else { // u가 올바른 괄호 문자열이 아닌 경우
            String temp = "(" + solution(v) + ")"; // v에 대해 재귀적으로 solution 수행한 결과 문자열을 양쪽에 괄호를 추가하여 저장

            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < u.length() - 1; i++) {
                if (u.charAt(i) == '(') {
                    sb.append(')');
                } else {
                    sb.append('(');
                }
            }

            return temp + sb.toString();
        }
    }

    // 문자열을 균형잡힌 괄호 문자열로 분리할 인덱스를 찾는 메소드
    private int getSplitIndex(String p) {
        int count = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                return i;
            }
        }
        return -1; // 올바른 괄호 문자열이 아닌 경우
    }

    // 문자열이 올바른 괄호 문자열인지 확인하는 메소드
    private boolean isCorrect(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        괄호체크 괄호체크 = new 괄호체크();
        String p = "())(";
        System.out.println(괄호체크.solution(p));
    }
}
