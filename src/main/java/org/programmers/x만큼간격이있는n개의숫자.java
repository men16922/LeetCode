package org.programmers;

import java.util.stream.LongStream;

public class x만큼간격이있는n개의숫자 {

    public long[] solution(int x, int n) {
        return LongStream.rangeClosed(1, n).map(item -> item * x).toArray();
    }

    public long[] solution_other(int x, int n) {
        long[] answer = new long[n];
        answer[0] = x;

        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] + x;
        }

        return answer;

    }

    public static void main(String[] args) {
        x만큼간격이있는n개의숫자 x만큼간격이있는n개의숫자 = new x만큼간격이있는n개의숫자();
        System.out.println(x만큼간격이있는n개의숫자.solution(2, 5));
    }
}
