package org.programmers;

public class LV1_2016년 {


    public String solution(int a, int b) {
        int[] months = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] days = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int totalDay = b;
        for (int i = 1; i < a; i++) {
            totalDay += months[i - 1];
        }
        String answer = days[(totalDay - 1) % 7];
        return answer;
    }

    public static void main(String[] args) {
        int a = 5;
        int b = 24;
        LV1_2016년 lv1_2016년 = new LV1_2016년();
        System.out.println(lv1_2016년.solution(a, b));
    }
}
