package org.softeer.lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class lv3_택배마스터 {

    static int[] rails;
    static int[] inputs;
    static boolean[] visit;

    static int N, M, K, minW;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        minW = M * K;

        st = new StringTokenizer(bf.readLine(), " ");

        rails = new int[N];
        inputs = new int[N];
        visit = new boolean[N];

        for (int i = 0; i < N; i++) {
            rails[i] = Integer.parseInt(st.nextToken());
        }

        perm(0, 0);
        System.out.println(minW);
    }

    static void perm(int start, int count) {
        if (count == N) {
            Queue<Integer> myQueue = new LinkedList<>();
            for (int v : inputs) {
                myQueue.offer(v);
            }

            int kCount = 0;
            int sum = 0;
            int total = 0;

            while (true) {
                sum += myQueue.peek();
                myQueue.offer(myQueue.poll());

                if (sum + myQueue.peek() > M) {
                    kCount++;
                    total += sum;
                    sum = 0;
                }

                if (kCount == K) break;
            }
            minW = Math.min(total, minW);
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                inputs[count] = rails[i];
                perm(0, count + 1);
                visit[i] = false;
            }
        }
    }
}

