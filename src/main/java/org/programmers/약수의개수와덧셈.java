package org.programmers;

public class 약수의개수와덧셈 {

    public int solution(int left, int right) {
        int answer = 0;
        for (int i = left; i <= right; i++) {
            int count = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    count++;
                }
            }
            if (count % 2 == 0) answer += i;
            else answer -= i;
        }
        return answer;
    }

    public int solution_other(int left, int right) {
        int answer = 0;

        for (int i=left;i<=right;i++) {
            //제곱수인 경우 약수의 개수가 홀수
            if (i % Math.sqrt(i) == 0) {
                answer -= i;
            }
            //제곱수가 아닌 경우 약수의 개수가 짝수
            else {
                answer += i;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        약수의개수와덧셈 약수의개수와덧셈 = new 약수의개수와덧셈();
        System.out.println(약수의개수와덧셈.solution(13, 17));
    }
}
