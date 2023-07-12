package org.baekjun;

import java.util.*;

public class p_1931 {

    static class Meet {
        int start;
        int end;

        public Meet(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Meet> meetList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            Meet meet = new Meet(start, end);
            meetList.add(meet);
        }

        Collections.sort(meetList, new Comparator<Meet>() {
            @Override
            public int compare(Meet o1, Meet o2) {
                if (o1.end == o2.end) {
                    return o1.start - o2.start;
                }

                return o1.end - o2.end;
            }
        });

        int count = 0;
        int endTime = 0; // 이전 회의 끝나는 시간

        for (Meet meet : meetList) {
            if (meet.start >= endTime) {
                count++;
                endTime = meet.end;
            }
        }
        System.out.println(count);
    }
}
