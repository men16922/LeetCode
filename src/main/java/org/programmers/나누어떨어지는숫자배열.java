package org.programmers;

import java.util.Arrays;

public class 나누어떨어지는숫자배열 {

    public int[] solution(int[] arr, int divisor) {
        int [] answer = Arrays.stream(arr).filter(item -> item % divisor == 0).sorted().toArray();
        if (answer.length == 0) return new int[]{-1};
        return answer;
    }

    public static void main(String[] args) {
        int [] arr = {5, 9, 7, 10};
        int divisor = 5;

        나누어떨어지는숫자배열 나누어떨어지는숫자배열 = new 나누어떨어지는숫자배열();
        System.out.println(나누어떨어지는숫자배열.solution(arr, divisor));
    }
}
