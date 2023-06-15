package org.programmers;

public class 콜라문제 {

    public int solution(int a, int b, int n) {
        int answer = 0;

        if (n < a) {
            return answer;
        }

        int num = n / a;
        answer += num * b;
        int remainingBottles = num * b + n % a;

        return answer + solution(a, b, remainingBottles);
    }

    public int solution_other(int a, int b, int n) {
        return (n > b ? n - b : 0) / (a - b) * b;
    }

    public static void main(String[] args) {
        int a = 2;
        int b = 1;
        int n = 20;
        콜라문제 콜라문제 = new 콜라문제();
        System.out.println(콜라문제.solution(a, b, n));
    }
}
