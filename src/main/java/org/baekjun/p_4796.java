package org.baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class p_4796 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        while (true) {
            String s = bf.readLine();
            int [] arr = Arrays.stream(s.split(" ")).mapToInt(item -> Integer.parseInt(item)).toArray();
            int l = arr[0];
            int p = arr[1];
            int v = arr[2];
            if(l == 0 && p == 0 && v ==0) break;
            int temp  = (v / p) * l + Math.min(l, v % p);
            list.add(temp);
        }
        int cnt = 0;
        for (int n : list) {
            System.out.println(String.format("Case %s: %s", ++cnt, n));
        }
    }
}
