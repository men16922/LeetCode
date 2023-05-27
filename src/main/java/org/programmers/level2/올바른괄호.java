package org.programmers.level2;

import java.util.Stack;

public class 올바른괄호 {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        if (stack.isEmpty()) return true;
        else return false;
    }

    boolean solution_other(String s) {
        boolean answer = false;
        int count = 0;
        for(int i = 0; i<s.length();i++){
            if(s.charAt(i) == '('){
                count++;
            }
            if(s.charAt(i) == ')'){
                count--;
            }
            if(count < 0){
                break;
            }
        }
        if(count == 0){
            answer = true;
        }

        return answer;
    }

    public static void main(String[] args) {
        String s = "(()(";
        올바른괄호 올바른괄호 = new 올바른괄호();
        System.out.println(올바른괄호.solution(s));
    }
}
