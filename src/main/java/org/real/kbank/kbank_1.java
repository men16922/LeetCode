package org.real.kbank;

import java.util.Map;

public class kbank_1 {

    public String solution(String lamps, int l, int r) {
        char[] newLamps = lamps.toCharArray();

        for (int i = l - 1; i < r; i++) {
            if (newLamps[i] != '.') {
                if (newLamps[i] == 'O') {
                    newLamps[i] = 'o';
                } else if (newLamps[i] == 'o') {
                    newLamps[i] = '.';
                }
            }
        }

        return new String(newLamps);
    }

    public static void main(String[] args) {
        String lamps = "OOOO";
        int l = 2;
        int r = 2;
        kbank_1 kbank_1 = new kbank_1();
        System.out.println(kbank_1.solution(lamps, l, r));
    }
}
