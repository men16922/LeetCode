package org.programmers;

import java.util.Arrays;

public class 자리수 {

    public int solution(int n) {
        int answer = 0;
        String num = Integer.toString(n);
        char [] charArray = num.toCharArray();

        for (char c : charArray) {
            answer += c - '0';
        }
        return answer;
    }

    public int solution_another(int n) {
        int answer = 0;

        while(true){
            answer+=n%10;
            if(n<10)
                break;

            n=n/10;
        }

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }

    public static void main(String[] args) {
        자리수 자리수 = new 자리수();
        int n = 1101;
        System.out.println(자리수.solution(n));
    }
}
