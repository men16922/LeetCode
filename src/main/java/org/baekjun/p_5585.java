package org.baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_5585 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = 1000 - Integer.parseInt(bf.readLine());
        int cnt = 0;
        int [] arr = {500, 100, 50, 10, 5, 1};
        for (int n : arr) {
            cnt += t / n;
            t %= n;
        }
        System.out.println(cnt);
    }
}
