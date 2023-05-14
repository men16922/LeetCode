package org.programmers;

public class 콜라츠추측 {

    public int solution(long num) {
        int answer = 0;
        if (num == 1) {
            return 0;
        }
        while (num != 1) {

            if (answer >= 500) {
                return -1;
            }

            if (num % 2 == 0) {
                num = num / 2;
            } else {
                num = 3 * num + 1;
            }
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        콜라츠추측 콜라츠추측 = new 콜라츠추측();
        int num = 626331;
        System.out.println(콜라츠추측.solution(num));
    }
}
