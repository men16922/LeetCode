package org.baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_2720 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        int [] arr = new int [t];
        for(int i = 0; i < t; i ++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }

        int [] money = {25, 10, 5, 1};

        for (int n : arr) {
            int quarter = n / money[0];
            int temp = n % money[0];
            int dime = temp / money[1];
            temp = temp % money[1];
            int nickel = temp / money[2];
            temp = temp % money[2];
            int penny = temp / money[3];
            temp = temp % money[3];
            System.out.println(quarter + " " + dime + " " + nickel + " " + penny);
        }

    }
}
