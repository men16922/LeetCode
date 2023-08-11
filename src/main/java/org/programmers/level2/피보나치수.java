package org.programmers.level2;

public class 피보나치수 {
    public int solution(int n) {
        int[] fibonacci = new int[n + 1];
        fibonacci[0] = 0;
        fibonacci[1] = 1;

        for (int i = 2; i <= n; i++) {
            fibonacci[i] = (fibonacci[i - 1] + fibonacci[i - 2]) % 1234567;
        }

        return fibonacci[n];
    }

    public static void main(String[] args) {
        int n = 5;
        피보나치수 피보나치수 = new 피보나치수();
        System.out.println(피보나치수.solution(n));
    }

}
