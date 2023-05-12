package org.programmers;

public class 정수제곱근판별 {

    public long solution(long n) {
        double sqrt = Math.sqrt((double) n);
        if (sqrt == (int) sqrt) {
            return (long) Math.pow(sqrt + 1, 2);
        }
        return -1;
    }

    public long solution_other(long n) {
        if (Math.pow((int)Math.sqrt(n), 2) == n) {
            return (long) Math.pow(Math.sqrt(n) + 1, 2);
        }

        return -1;
    }

    public static void main(String[] args) {
        정수제곱근판별 정수제곱근판별 = new 정수제곱근판별();
        System.out.println(정수제곱근판별.solution(5));
    }
}
