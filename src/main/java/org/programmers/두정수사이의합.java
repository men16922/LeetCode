package org.programmers;

public class 두정수사이의합 {

    public long solution(int a, int b) {
        long start = Math.min(a, b);
        long end = Math.max(a, b);
        long answer = 0;

        for (long i = start; i <= end; i++) {
            answer += i;
        }

        return answer;
    }

    public long solution_other(int a, int b) {
        return sumAtoB(Math.min(a, b), Math.max(b, a));
    }

    private long sumAtoB(long a, long b) {
        return (b - a + 1) * (a + b) / 2;
    }

    public static void main(String[] args) {
        int a = 3;
        int b = 5;
        두정수사이의합 두정수사이의합 = new 두정수사이의합();
        System.out.println(두정수사이의합.solution(a, b));
    }
}
