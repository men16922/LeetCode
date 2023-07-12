package org.baekjun;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class p_11047 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int [] arr = new int [n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        arr = Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();
        int min = 0;
        for (int num : arr) {
            if (k == 0) break;
            min += k / num;
            k = k % num;
        }
        System.out.println(min);
    }
}
