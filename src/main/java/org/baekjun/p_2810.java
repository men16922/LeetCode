package org.baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class p_2810 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        String s = bf.readLine();
        Stack<Character> stack = new Stack<>();
        stack.push('*');
        char [] chars = s.toCharArray();
        for (int i = 0 ; i < t; i++) {
            if (chars[i] == 'S') {
                if (stack.peek() != '*') stack.push('*');
                stack.push(chars[i]);
            } else {
                if (stack.peek() != '*') stack.push('*');
                stack.push(chars[i]);
                stack.push(chars[i]);
                i++;
            }
            stack.push('*');
        }
        long count = stack.stream().filter(item -> item == '*').count();
        System.out.println(Math.min(Math.toIntExact(count), t));
    }
}
