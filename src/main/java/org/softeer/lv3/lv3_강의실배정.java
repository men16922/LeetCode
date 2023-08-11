package org.softeer.lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class lv3_강의실배정 {

    static class Lesson implements Comparable<Lesson> {
        int start;
        int end;

        public Lesson(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Lesson o) {
            if(this.end < o.end) {
                return -1;
            } else if (this.end == o.end) {
                return 0;
            } else {
                return 1;
            }
        }

        @Override
        public String toString() {
            return "Lesson{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        List<Lesson> lessonList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            Lesson lesson = new Lesson(start, end);
            lessonList.add(lesson);
        }
        Collections.sort(lessonList);

        int answer = 1;
        Lesson curLesson = lessonList.get(0);
        for (int i = 1; i < N; i++) {
            if (curLesson.end < lessonList.get(i).end && curLesson.end <= lessonList.get(i).start) {
                answer++;
                curLesson = lessonList.get(i);
            }
        }
        System.out.println(answer);
    }
}
