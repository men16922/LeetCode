package org.softeer.lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class lv3_스마트물류 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);

        char[] r = br.readLine().toCharArray();
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if (r[i] == 'P') {
                for (int j = i - k; j <= i + k; j++) {
                    if (j < 0 || j >= n) {
                        continue;
                    }

                    if (r[j] == 'H') {
                        cnt++;
                        r[j] = 'A';
                        break;
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}
