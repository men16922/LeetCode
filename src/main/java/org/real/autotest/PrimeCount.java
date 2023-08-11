package org.real.autotest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PrimeCount {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int P = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int ans = 0;
        for (int X = P; X <= Q; X++) {
            int cnt = 0;
            for (int A = 2; A * A <= X; A++) {
                if (X % A == 0) {
                    cnt++;
                }
            }

            if (cnt == 1) {
                ans++;
            }
        }

        System.out.println(ans);
    }
}

