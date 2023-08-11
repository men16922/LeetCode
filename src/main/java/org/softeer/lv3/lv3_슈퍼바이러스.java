package org.softeer.lv3;

import java.io.*;
import java.util.StringTokenizer;

public class lv3_슈퍼바이러스 {

    static final long MOD = 1000000007;

    public static long sol(long n, long P) {
        if (n == 1) return P;
        long ret = sol(n / 2, P);
        ret = (ret * ret) % MOD;
        if (n % 2 == 1) ret = (ret * P) % MOD;
        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long K = Long.parseLong(st.nextToken());
        long P = Long.parseLong(st.nextToken());
        long N = Long.parseLong(st.nextToken());

        System.out.println((sol(N * 10, P) * K) % MOD);
    }
}
