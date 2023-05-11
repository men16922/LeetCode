package org.programmers;

import java.util.stream.IntStream;

public class 나머지가1이되는수 {
    public int solution(int n) {
        int answer = 0;

        for(int i = 1; i < n; i++){
            if (n % i == 1) {
                answer = i;
                break;
            }
        }

        return answer;
    }

    public int solution_other(int n) {
        return IntStream.range(2, n).filter(i -> n % i == 1).findFirst().orElse(0);
    }

    public static void main(String[] args) {
        int n = 12;
        나머지가1이되는수 나머지가1이되는수 = new 나머지가1이되는수();
        System.out.println(나머지가1이되는수.solution(n));
    }
}
