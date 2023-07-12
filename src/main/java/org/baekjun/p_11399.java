package org.baekjun;

import java.util.Arrays;
import java.util.Scanner;

public class p_11399 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int [n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        arr = Arrays.stream(arr).sorted().toArray();
        int cur = 0;
        int result = 0;
        for (int num : arr) {
            cur += num;
            result += cur;
        }
        System.out.println(result);
    }
}
