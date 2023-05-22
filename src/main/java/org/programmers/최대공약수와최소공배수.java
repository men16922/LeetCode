package org.programmers;

public class 최대공약수와최소공배수 {

    public int gcd (int a, int b) {
        if (b == 0) return a;
        else return gcd(b, a % b);
    }

    public int lcm (int a, int b) {
        return  (a * b) / gcd(a, b);
    }

    public int[] solution(int n, int m) {
        int[] answer = {gcd(n, m), lcm(n, m)};
        return answer;
    }

    public static void main(String[] args) {
        int n = 3;
        int m = 12;
        최대공약수와최소공배수 최대공약수와최소공배수 = new 최대공약수와최소공배수();
        System.out.println(최대공약수와최소공배수.solution(n, m));
    }

}
