package org.baekjun;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p_10162 {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        int [] arr = {300, 60, 10};
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (arr[i] > t) {
                list.add(0);
                continue;
            }
            int temp = t / arr[i];
            list.add(temp);
            t -= arr[i] * temp;
        }
        if (t != 0) System.out.println(-1);
        else for (int n : list) {
            System.out.print(n + " ");
        }
    }
}
