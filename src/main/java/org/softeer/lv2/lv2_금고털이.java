package org.softeer.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class lv2_금고털이 {



    static class Package implements Comparable<Package> {
        int M;
        int P;


        public Package(int m, int p) {
            M = m;
            P = p;
        }

        @Override
        public int compareTo(Package o) {
            if (this.P > o.P) return 1;
            else if (this.P < o.P) return -1;
            else return 0;
        }

        @Override
        public String toString() {
            return "Package{" +
                    "M=" + M +
                    ", P=" + P;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int W = Integer.parseInt(st.nextToken()); // 배낭의 무게
        int N = Integer.parseInt(st.nextToken()); // 귀금속의 종류
        List<Package> packageList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            s = bf.readLine();
            st = new StringTokenizer(s);
            int M = Integer.parseInt(st.nextToken()); // 귀금속의 무게
            int P = Integer.parseInt(st.nextToken()); // 무게당 가격
            Package pack = new Package(M, P);
            packageList.add(pack);
        }
        Collections.sort(packageList, Collections.reverseOrder());
        int totalPrice = 0;
        for (Package p : packageList) {
            // 현재 무게가 초과하는지 계산
            W -= p.M;
            totalPrice += p.M * p.P;
            if (W < 0) {
                totalPrice += W * p.P;
                break;
            }
        }
        System.out.println(totalPrice);
    }
}
