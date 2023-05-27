package org.programmers.level2;

import java.util.Stack;

public class JadenCase문자열만들기 {

    public String solution(String s) {
        Stack<Character> stack = new Stack<>();
        char [] charArray = s.toCharArray();
        stack.push(Character.toUpperCase(charArray[0]));
        for (int i = 1; i < s.length(); i++) {
            if (stack.peek() != ' ') stack.push(Character.toLowerCase(charArray[i]));
            else stack.push(Character.toUpperCase(charArray[i]));
        }
        String answer = "";
        while (!stack.isEmpty()) {
            answer += stack.pop().toString();
        }
        return new StringBuilder(answer).reverse().toString();
    }

    public String solution_other(String s) {
        String answer = "";
        String[] sp = s.toLowerCase().split("");
        boolean flag = true;

        for(String ss : sp) {
            answer += flag ? ss.toUpperCase() : ss;
            flag = ss.equals(" ") ? true : false;
        }

        return answer;
    }

    public static void main(String[] args) {
        String s = "3people unFollowed me  1 2";
        JadenCase문자열만들기 jadenCase문자열만들기 = new JadenCase문자열만들기();
        System.out.println(jadenCase문자열만들기.solution(s));
    }
}
