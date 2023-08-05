package org.softeer.lv2;

import java.util.Scanner;

public class lv2_8단변속기 {

    enum Checker {
        ascending, descending, mixed;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] arr = new int [8];
        for (int i = 0; i < 8; i++) {
            arr[i] = sc.nextInt();
        }
        Checker checker = Checker.mixed;
        int ascCount = 0;
        int descCount = 0;
        int cur = arr[0]; // 현재 값
        int next = 0; // 다음 값
        for (int i = 1; i< 8; i++) {
            next = arr[i];
            if (cur < next) {
                ascCount++;
            } else if (cur > next) {
                descCount++;
            } else {
                checker = Checker.mixed;
                break;
            }
            cur = arr[i];
        }

        if (ascCount == 7) {
            checker = Checker.ascending;
        } else if (descCount == 7) {
            checker = Checker.descending;
        }
        System.out.println(checker.name());
    }
}
