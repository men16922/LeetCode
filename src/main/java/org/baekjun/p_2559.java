package org.baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class p_2559 {
    static class Node {
        public int value;
        public int index;

        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Deque<Node> deque = new ArrayDeque<>();

        s = bf.readLine();
        st = new StringTokenizer(s);
        int maxTotal = Integer.MIN_VALUE;
        int curTotal = 0;
        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(st.nextToken()); // 새롭게 들어오는 값
            deque.addLast(new Node(cur, i)); // 마지막 값 추가
            curTotal += cur;
            // 덱이 비어있지 않고, 덱의 크기가 K보다 크면, 첫번째 값 제거
            if (deque.size() > K) {
                Node removedNode = deque.removeFirst();
                curTotal -= removedNode.value;
            }

            if (deque.size() == K) {
                maxTotal = Math.max(maxTotal, curTotal);
            }

        }
        System.out.println(maxTotal);
    }
}
