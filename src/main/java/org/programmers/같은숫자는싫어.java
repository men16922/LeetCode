package org.programmers;

import java.util.Arrays;
import java.util.Stack;

public class 같은숫자는싫어 {

    public int[] solution(int [] arr) {
        int[] answer = {};
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        Arrays.stream(arr).forEach(item -> {
            if (stack.peek() != item) {
                stack.push(item);
            }
        });
        return stack.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        같은숫자는싫어 같은숫자는싫어 = new 같은숫자는싫어();
        int [] arr = {1,1,3,3,0,1,1};
        System.out.println(같은숫자는싫어.solution(arr));
    }
}
