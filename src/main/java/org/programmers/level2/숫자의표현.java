package org.programmers.level2;

public class 숫자의표현 {
    public int solution(int n) {
        int answer = 0;

        int start = 1; // 시작 숫자
        int sum = 0; // 연속된 숫자의 합

        for (int i = 1; i <= n; i++) {
            sum += i;
            while (sum > n) {
                sum -= start;
                start++;
            }
            if (sum == n) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        숫자의표현 숫자의표현 = new 숫자의표현();
        int n = 15;
        System.out.println(숫자의표현.solution(n));
    }
}
