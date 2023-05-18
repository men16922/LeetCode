package org.programmers;

public class 부족한금액계산하기 {
    public long solution(int price, int money, int count) {
        int totalPrice = 0;
        for (int i = 0; i < count; i++) {
            totalPrice += price * (i + 1);
        }
        return totalPrice > money ? totalPrice - money : 0;
    }

    public static void main(String[] args) {
        부족한금액계산하기 부족한금액계산하기 = new 부족한금액계산하기();
        System.out.println(부족한금액계산하기.solution(3, 20, 5));
    }
}
