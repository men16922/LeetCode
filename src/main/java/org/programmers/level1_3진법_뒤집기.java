package org.programmers;

public class level1_3진법_뒤집기 {

    public int solution(int n) {
        String ternary = "";
        while (n > 0) {
            ternary += n % 3;
            n /= 3;
        }

        int answer = 0;
        int power = 0;
        for (int i = ternary.length() - 1; i >= 0; i--) {
            int digit = ternary.charAt(i) - '0';
            answer += digit * Math.pow(3, power);
            power++;
        }

        return answer;
    }

    public int solution_other(int n) {
        String a = "";

        while(n > 0){
            a = (n % 3) + a;
            n /= 3;
        }
        a = new StringBuilder(a).reverse().toString();


        return Integer.parseInt(a,3);
    }

    public static void main(String[] args) {
        level1_3진법_뒤집기 level1_3진법_뒤집기 = new level1_3진법_뒤집기();
        int n = 45;
        System.out.println(level1_3진법_뒤집기.solution(n));
    }
}
